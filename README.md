# Code_Challenges
Challenges
<br>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Code Challenges - Animated Welcome</title>
  <style>
    body {
      background: #0f172a;
      color: #fbbf24;
      font-family: 'Fira Mono', 'Consolas', monospace;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .typewriter h1 {
      overflow: hidden;
      border-right: .15em solid #fbbf24;
      white-space: nowrap;
      margin: 0 auto;
      letter-spacing: .15em;
      animation:
        typing 3s steps(30, end),
        blink-caret .75s step-end infinite;
      font-size: 2.5rem;
    }
    @keyframes typing {
      from { width: 0 }
      to { width: 100% }
    }
    @keyframes blink-caret {
      from, to { border-color: transparent }
      50% { border-color: #fbbf24 }
    }
  </style>
</head>
<body>
  <div class="typewriter">
    <h1>Welcome to Code Challenges! 🚀</h1>
  </div>
</body>
</html>
