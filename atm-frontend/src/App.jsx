import { useState } from "react";
import "./App.css";

function App() {
  const [cardNumber, setCardNumber] = useState("");
  const [pin, setPin] = useState("");
  const [message, setMessage] = useState("");
  const [userName, setUserName] = useState("");
  const [isError, setIsError] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [accountSummary, setAccountSummary] = useState(null);
  const [selectedAccountNumber, setSelectedAccountNumber] = useState("");
  const [balance, setBalance] = useState(null);
  const [depositAmount, setDepositAmount] = useState("");
  const [withdrawAmount, setWithdrawAmount] = useState("");
  const [transferAmount, setTransferAmount] = useState("");
  const [activeAction, setActiveAction] = useState("");
  const [transactions, setTransactions] = useState([]);

  async function handleLogin(event) {
    event.preventDefault();

    setMessage("");
    setUserName("");
    setIsError(false);
    setAccountSummary(null);
    setSelectedAccountNumber("");
    setBalance(null);
    setActiveAction("");
    setTransactions([]);

    try {
      const response = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          cardNumber: cardNumber,
          pin: pin
        })
      });

      const data = await response.json();

      if (response.ok) {
        setMessage(data.message);
        setUserName(data.name);
        setIsError(false);
        setIsLoggedIn(true);

        await fetchAccountSummary(cardNumber);
      } else {
        setMessage(data.message);
        setIsError(true);
        setIsLoggedIn(false);
      }
    } catch (error) {
      setMessage("Unable to connect to the backend. Make sure Spring Boot is running.");
      setIsError(true);
      setIsLoggedIn(false);
    }
  }

  async function fetchAccountSummary(cardNumber) {
    try {
      const response = await fetch(`http://localhost:8080/api/users/${cardNumber}/accounts`);
      const data = await response.json();

      if (response.ok) {
        setAccountSummary(data);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to load account summary.");
      setIsError(true);
    }
  }

  async function handleSelectAccount(accountNumber) {
    setSelectedAccountNumber(accountNumber);
    setBalance(null);
    setDepositAmount("");
    setWithdrawAmount("");
    setTransferAmount("");
    setTransactions([]);
    setActiveAction("");
    setMessage("");
    setIsError(false);

    try {
      const response = await fetch(`http://localhost:8080/api/accounts/${accountNumber}/balance`);
      const data = await response.json();

      if (response.ok) {
        setBalance(data.balance);
        setMessage("Account selected successfully");
        setIsError(false);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to load account balance.");
      setIsError(true);
    }
  }

  async function handleDeposit(event) {
    event.preventDefault();

    if (!selectedAccountNumber) {
      setMessage("Please select an account first.");
      setIsError(true);
      return;
    }

    try {
      const response = await fetch(
        `http://localhost:8080/api/accounts/${selectedAccountNumber}/deposit`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            amount: Number(depositAmount)
          })
        }
      );

      const data = await response.json();

      if (response.ok) {
        setBalance(data.newBalance);
        setMessage(data.message);
        setDepositAmount("");
        setTransactions([]);
        setIsError(false);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to complete deposit.");
      setIsError(true);
    }
  }

  async function handleWithdraw(event) {
    event.preventDefault();

    if (!selectedAccountNumber) {
      setMessage("Please select an account first.");
      setIsError(true);
      return;
    }

    try {
      const response = await fetch(
        `http://localhost:8080/api/accounts/${selectedAccountNumber}/withdraw`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            amount: Number(withdrawAmount)
          })
        }
      );

      const data = await response.json();

      if (response.ok) {
        setBalance(data.newBalance);
        setMessage(data.message);
        setWithdrawAmount("");
        setTransactions([]);
        setIsError(false);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to complete withdrawal.");
      setIsError(true);
    }
  }

  async function handleTransfer(event) {
    event.preventDefault();

    if (!selectedAccountNumber) {
      setMessage("Please select an account first.");
      setIsError(true);
      return;
    }

    const toAccountNumber = selectedAccountNumber === "1001" ? "1002" : "1001";

    try {
      const response = await fetch("http://localhost:8080/api/transfer", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          fromAccountNumber: selectedAccountNumber,
          toAccountNumber: toAccountNumber,
          amount: Number(transferAmount)
        })
      });

      const data = await response.json();

      if (response.ok) {
        setBalance(data.fromAccountBalance);
        setMessage(data.message);
        setTransferAmount("");
        setTransactions([]);
        setIsError(false);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to complete transfer.");
      setIsError(true);
    }
  }

  async function fetchTransactionHistory() {
    if (!selectedAccountNumber) {
      setMessage("Please select an account first.");
      setIsError(true);
      return;
    }

    try {
      const response = await fetch(
        `http://localhost:8080/api/accounts/${selectedAccountNumber}/transactions`
      );

      const data = await response.json();

      if (response.ok) {
        setTransactions(data);
        setMessage("Transaction history loaded");
        setIsError(false);
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to load transaction history.");
      setIsError(true);
    }
  }

  function handleLogout() {
    setCardNumber("");
    setPin("");
    setMessage("");
    setUserName("");
    setIsError(false);
    setIsLoggedIn(false);
    setAccountSummary(null);
    setSelectedAccountNumber("");
    setBalance(null);
    setDepositAmount("");
    setWithdrawAmount("");
    setTransferAmount("");
    setActiveAction("");
    setTransactions([]);
  }

  return (
    <div className="app">
      <div className="background-glow"></div>

      {!isLoggedIn ? (
        <main className="login-card">
          <div className="brand-row">
            <div className="logo">ATM</div>
            <div>
              <p className="eyebrow">Java Banking System</p>
              <h1>Welcome back</h1>
            </div>
          </div>

          <p className="subtitle">
            Sign in with your card number and PIN to access your account dashboard.
          </p>

          <form onSubmit={handleLogin} className="login-form">
            <label>
              Card Number
              <input
                type="text"
                value={cardNumber}
                onChange={(event) => setCardNumber(event.target.value)}
                placeholder="123456"
              />
            </label>

            <label>
              PIN
              <input
                type="password"
                value={pin}
                onChange={(event) => setPin(event.target.value)}
                placeholder="1111"
              />
            </label>

            <button type="submit">Log In</button>
          </form>

          {message && (
            <div className={isError ? "message error" : "message success"}>
              <p>{message}</p>
              {userName && <strong>Hello, {userName}!</strong>}
            </div>
          )}

          <div className="sample-box">
            <p>Sample login</p>
            <span>Card: 123456</span>
            <span>PIN: 1111</span>
          </div>
        </main>
      ) : (
        <main className="dashboard-card">
          <div className="dashboard-header">
            <div>
              <p className="eyebrow">Account Dashboard</p>
              <h1>Welcome, {userName}</h1>
            </div>

            <button className="logout-button" onClick={handleLogout}>
              Logout
            </button>
          </div>

          <p className="subtitle">Choose an account to view and manage the balance.</p>

          {accountSummary && (
            <div className="account-grid">
              {accountSummary.hasChecking && (
                <button
                  className={
                    selectedAccountNumber === "1001"
                      ? "account-card active selected"
                      : "account-card active"
                  }
                  onClick={() => handleSelectAccount("1001")}
                >
                  <p>Checking Account</p>
                  <h2>Available</h2>
                  <span>Account #1001</span>
                </button>
              )}

              {accountSummary.hasSavings && (
                <button
                  className={
                    selectedAccountNumber === "1002"
                      ? "account-card active selected"
                      : "account-card active"
                  }
                  onClick={() => handleSelectAccount("1002")}
                >
                  <p>Savings Account</p>
                  <h2>Available</h2>
                  <span>Account #1002</span>
                </button>
              )}
            </div>
          )}

          {selectedAccountNumber && balance !== null && (
            <>
              <div className="balance-card">
                <p>Selected Account</p>
                <h2>{selectedAccountNumber}</h2>
                <p>Current Balance</p>
                <strong>${balance.toFixed(2)}</strong>
              </div>

              <div className="action-panel">
                <p className="section-title">What would you like to do?</p>

                <div className="action-buttons">
                  <button
                    className={
                      activeAction === "deposit"
                        ? "action-button selected-action"
                        : "action-button"
                    }
                    onClick={() => setActiveAction("deposit")}
                  >
                    Deposit
                  </button>

                  <button
                    className={
                      activeAction === "withdraw"
                        ? "action-button selected-action"
                        : "action-button"
                    }
                    onClick={() => setActiveAction("withdraw")}
                  >
                    Withdraw
                  </button>

                  <button
                    className={
                      activeAction === "transfer"
                        ? "action-button selected-action"
                        : "action-button"
                    }
                    onClick={() => setActiveAction("transfer")}
                  >
                    Transfer
                  </button>

                  <button
                    className={
                      activeAction === "history"
                        ? "action-button selected-action"
                        : "action-button"
                    }
                    onClick={() => {
                      setActiveAction("history");
                      fetchTransactionHistory();
                    }}
                  >
                    History
                  </button>
                </div>

                {activeAction === "deposit" && (
                  <form onSubmit={handleDeposit} className="money-form single-form">
                    <h3>Deposit Money</h3>
                    <p>Add funds to your selected account.</p>

                    <input
                      type="number"
                      value={depositAmount}
                      onChange={(event) => setDepositAmount(event.target.value)}
                      placeholder="Enter amount, ex: 100"
                    />

                    <button type="submit">Submit Deposit</button>
                  </form>
                )}

                {activeAction === "withdraw" && (
                  <form onSubmit={handleWithdraw} className="money-form single-form">
                    <h3>Withdraw Money</h3>
                    <p>Withdraw funds from your selected account.</p>

                    <input
                      type="number"
                      value={withdrawAmount}
                      onChange={(event) => setWithdrawAmount(event.target.value)}
                      placeholder="Enter amount, ex: 50"
                    />

                    <button type="submit">Submit Withdrawal</button>
                  </form>
                )}

                {activeAction === "transfer" && (
                  <form onSubmit={handleTransfer} className="money-form single-form">
                    <h3>Transfer Money</h3>

                    <p className="transfer-route">
                      From account <span>#{selectedAccountNumber}</span> to account{" "}
                      <span>#{selectedAccountNumber === "1001" ? "1002" : "1001"}</span>
                    </p>

                    <input
                      type="number"
                      value={transferAmount}
                      onChange={(event) => setTransferAmount(event.target.value)}
                      placeholder="Enter amount, ex: 100"
                    />

                    <button type="submit">Submit Transfer</button>
                  </form>
                )}

                {activeAction === "history" && (
                  <div className="history-panel">
                    <h3>Transaction History</h3>

                    {transactions.length === 0 ? (
                      <p>No transactions found for this account yet.</p>
                    ) : (
                      <div className="history-list">
                        {transactions.map((transaction, index) => (
                          <div className="history-item" key={index}>
                            <div>
                              <p>{transaction.type}</p>
                              <span>Amount: ${transaction.amount.toFixed(2)}</span>
                            </div>

                            <strong>
                              Balance: ${transaction.balanceAfterTransaction.toFixed(2)}
                            </strong>
                          </div>
                        ))}
                      </div>
                    )}
                  </div>
                )}
              </div>
            </>
          )}

          {message && (
            <div className={isError ? "message error" : "message success"}>
              <p>{message}</p>
            </div>
          )}

          <div className="next-step-box">
            <p>Next UI step</p>
            <span>Polish the dashboard and commit the React frontend progress.</span>
          </div>
        </main>
      )}
    </div>
  );
}

export default App;