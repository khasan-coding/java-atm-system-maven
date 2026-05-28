import { useState } from "react";
import "./App.css";

function App() {
  const [cardNumber, setCardNumber] = useState("");
  const [pin, setPin] = useState("");
  const [message, setMessage] = useState("");
  const [userName, setUserName] = useState("");
  const [isError, setIsError] = useState(false);

  async function handleLogin(event) {
    event.preventDefault();

    setMessage("");
    setUserName("");
    setIsError(false);

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
      } else {
        setMessage(data.message);
        setIsError(true);
      }
    } catch (error) {
      setMessage("Unable to connect to the backend. Make sure Spring Boot is running.");
      setIsError(true);
    }
  }

  return (
    <div className="app">
      <div className="background-glow"></div>

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
    </div>
  );
}

export default App;