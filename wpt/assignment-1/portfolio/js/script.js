const aboutButton = document.getElementById("cta-home-get-to-know-me");

if (aboutButton) {
  aboutButton.addEventListener("click", function () {
    window.location.href = "about.html";
  });
}

const projectButton = document.getElementById("about-me-btn");
if (projectButton) {
  projectButton.addEventListener("click", function () {
    window.location.href = "projects.html";
  });
}

const sayHelloBtn = document.getElementById("cta-home-say-hello");
const sayHello = document.getElementById("say-hello");

if (sayHelloBtn && sayHello) {
  sayHelloBtn.addEventListener("click", () => {
    if (sayHello.style.display === "none") {
      sayHello.style.display = "flex";
    } else {
      sayHello.style.display = "none";
    }
  });
}

const welcomeBtn = document.getElementById("welcome-btn");
let welcomeMessage = document.querySelector(".home");

if (welcomeBtn) {
  welcomeBtn.addEventListener("click", () => {
    const userName = document.getElementById("say-hello-input").value;
    if (userName.trim().length > 0) {
      welcomeMessage.innerHTML = `Welcome ${userName}!`;
    } else if (userName == "") {
      welcomeMessage.innerHTML = "Hey visitor, I'm Satyam Bhosale";
    }
  });
}

const lightMode = document.getElementById("light-mode");
lightMode.addEventListener("click", () => {
  
});
