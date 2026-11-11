<!DOCTYPE html>
<html lang="id">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Florist Login</title>

<style>
* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #fff8f8;
    color: #392b2d;
}

header {
    text-align: center;
    padding: 18px;
    background: white;
    border-bottom: 1px solid #f3e1e3;
    position: relative;
}

.back {
    position: absolute;
    left: 20px;
    top: 15px;
    font-size: 25px;
    cursor: pointer;
}

.container {
    max-width: 400px;
    margin: auto;
    padding: 20px;
}

.tag {
    text-align: center;
    color: #914b55;
    font-size: 11px;
    margin-top: 10px;
}

h1 {
    text-align: center;
    font-family: Georgia, serif;
    margin-bottom: 8px;
}

.subtitle {
    text-align: center;
    color: #856d70;
    font-size: 13px;
    margin-bottom: 30px;
}

.box {
    background: white;
    padding: 20px;
    border-radius: 16px;
}

label {
    display: block;
    font-size: 13px;
    margin-bottom: 7px;
    font-weight: bold;
}

input {
    width: 100%;
    padding: 15px;
    border: none;
    outline: none;
    border-radius: 12px;
    background: #fff0f1;
    margin-bottom: 15px;
}

.password {
    display: flex;
    align-items: center;
    background: #fff0f1;
    border-radius: 12px;
    margin-bottom: 8px;
}

.password input {
    margin: 0;
    background: transparent;
}

.eye {
    padding: 10px;
    cursor: pointer;
}

.forgot {
    text-align: right;
    font-size: 11px;
    margin-bottom: 12px;
}

button {
    cursor: pointer;
}

.main-btn {
    width: 100%;
    padding: 14px;
    border: none;
    border-radius: 30px;
    background: #914b55;
    color: white;
    font-size: 15px;
}

.divider {
    text-align: center;
    color: #967b7e;
    margin: 30px 0;
    font-size: 12px;
}

.google-btn {
    width: 100%;
    padding: 14px;
    border: none;
    border-radius: 30px;
    background: white;
    font-size: 14px;
}

.google {
    color: #4285f4;
    font-weight: bold;
    font-size: 18px;
}

.bottom {
    text-align: center;
    margin-top: 25px;
    font-size: 13px;
    color: #856d70;
}

a {
    color: #914b55;
    text-decoration: none;
    font-weight: bold;
}

.hidden {
    display: none;
}
</style>
</head>

<body>

<header>
    <span class="back" onclick="back()">←</span>
    <b id="title">Login</b>
</header>

<div class="container">

    <div class="tag">❀ MORE THAN JUST A GIFT</div>

    <!-- LOGIN -->
    <section id="login">

        <h1>Welcome Back!</h1>
        <p class="subtitle">Masuk untuk melanjutkan pesanan manis Anda</p>

        <div class="box">
            <form id="loginForm">

                <label>Email</label>
                <input type="email" id="email"
                placeholder="nama@email.com" required>

                <label>Password</label>
                <div class="password">
                    <input type="password" id="pass"
                    placeholder="Masukkan kata sandi" required>
                    <span class="eye" onclick="toggle('pass')">👁</span>
                </div>

                <div class="forgot">
                    <a href="#" onclick="forgot()">Lupa password?</a>
                </div>

                <button class="main-btn">Login →</button>

            </form>
        </div>

        <div class="bottom">
            Belum punya akun?
            <a href="#" onclick="show('register')">Daftar</a>
        </div>

    </section>

    <!-- REGISTER -->
    <section id="register" class="hidden">

        <h1>Create Account!</h1>
        <p class="subtitle">Buat akun baru untuk mulai berbelanja</p>

        <div class="box">
            <form id="registerForm">

                <label>Nama Lengkap</label>
                <input type="text" id="name"
                placeholder="Nama lengkap" required>

                <label>Email</label>
                <input type="email" id="newEmail"
                placeholder="nama@email.com" required>

                <label>Password</label>
                <div class="password">
                    <input type="password" id="newPass"
                    placeholder="Minimal 6 karakter" minlength="6" required>
                    <span class="eye" onclick="toggle('newPass')">👁</span>
                </div>

                <label>Konfirmasi Password</label>
                <input type="password" id="confirm"
                placeholder="Ulangi password" required>

                <button class="main-btn">Daftar →</button>

            </form>
        </div>

        <div class="bottom">
            Sudah punya akun?
            <a href="#" onclick="show('login')">Login</a>
        </div>

    </section>

</div>

<!-- FIREBASE -->
<script src="https://www.gstatic.com/firebasejs/10.12.2/firebase-app-compat.js"></script>
<script src="https://www.gstatic.com/firebasejs/10.12.2/firebase-auth-compat.js"></script>

<script>

// Masukkan konfigurasi Firebase kamu
const firebaseConfig = {
    apiKey: "ISI_API_KEY",
    authDomain: "ISI_AUTH_DOMAIN",
    projectId: "ISI_PROJECT_ID",
    appId: "ISI_APP_ID"
};

firebase.initializeApp(firebaseConfig);
const auth = firebase.auth();

// Pindah Login dan Register
function show(page) {
    document.getElementById("login").classList.toggle("hidden", page !== "login");
    document.getElementById("register").classList.toggle("hidden", page !== "register");
    document.getElementById("title").textContent =
        page === "login" ? "Login" : "Daftar";
}

function back() {
    if (!document.getElementById("register").classList.contains("hidden")) {
        show("login");
    } else {
        history.back();
    }
}

// Tampilkan Password
function toggle(id) {
    let input = document.getElementById(id);
    input.type = input.type === "password" ? "text" : "password";
}

// Login
document.getElementById("loginForm").onsubmit = function(e) {
    e.preventDefault();

    auth.signInWithEmailAndPassword(
        email.value, pass.value
    ).then(() => {
        alert("Login berhasil!");
    }).catch(error => alert(error.message));
};

// Register
document.getElementById("registerForm").onsubmit = function(e) {
    e.preventDefault();

    if (newPass.value !== confirm.value) {
        alert("Password tidak sama!");
        return;
    }

    auth.createUserWithEmailAndPassword(
        newEmail.value, newPass.value
    ).then(result => {
        return result.user.updateProfile({
            displayName: name.value
        });
    }).then(() => {
        alert("Akun berhasil dibuat!");
        show("login");
    }).catch(error => alert(error.message));
};

// Lupa Password
function forgot() {
    if (!email.value) {
        alert("Masukkan email terlebih dahulu!");
        return;
    }

    auth.sendPasswordResetEmail(email.value)
    .then(() => alert("Link reset password sudah dikirim!"))
    .catch(error => alert(error.message));
}

</script>

</body>
</html>
