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

const showSkillBtn = document.getElementById("show-skills");
const skills = document.getElementById("skills");
if(showSkillBtn){
  showSkillBtn.addEventListener("click",()=>{
    if(skills.style.display === "none"){
      skills.style.display = "block";
      showSkillBtn.textContent="Hide";
    }else{
      skills.style.display="none";
      showSkillBtn.textContent = "Show";
    }
  })
}






//dark-light
let darkMode = true;

document.addEventListener("click", (event) => {
  const lightMode = event.target.closest("#light-mode");

  if (!lightMode) return;

  const mainBtns = [
    document.querySelector(".subscribe-btn"),
    document.querySelector("#about-me-btn"),
    document.querySelector("#show-skills-btn"),
    document.querySelector(".submit-form"),
    document.querySelector(".reset-form"),
    document.querySelector("#show-skills")
  ];

  const mainCards = [
    document.querySelector("#email-field"),
    document.querySelector("#about-me"),
    document.querySelector("#left-about"),
    document.querySelector("#mid-about"),
    document.querySelector("#right-about"),
    document.querySelector("#curr-proj-1"),
    document.querySelector("#curr-proj-2"),
    document.querySelector("#contact-form")
  ];

  const tableCells = document.querySelectorAll(
    "#project-table th, #project-table td"
  );

  if (darkMode) {
    document.body.style.backgroundColor = "#fff";
    document.body.style.color = "#000";
    // document.border.style.color = "#000";

    mainBtns.forEach((btns) => {
      if (btns) {
        btns.style.backgroundColor = "#000";
        btns.style.color = "#fff";

        btns.onmouseenter = () => {
          btns.style.backgroundColor = "#ffffff";
          btns.style.color = "#000000";
        };
        btns.onmouseleave = () => {
          btns.style.backgroundColor = "#000000";
          btns.style.color = "#ffffff";
        };
      }
    });

    mainCards.forEach((cards) => {
      if (cards) {
        cards.style.borderColor = "#000";
      }
    });

    tableCells.forEach((cell) => {
      cell.style.borderColor = "#000000";
    });

    lightMode.textContent = "Dark Mode";
    darkMode = false;
    // document.body.classList.add("light-theme");
  } else {
    document.body.style.backgroundColor = "#000";
    document.body.style.color = "#fff";
    mainBtns.forEach((btns) => {
      if (btns) {
        btns.style.backgroundColor = "#fff";
        btns.style.color = "#000";

        btns.onmouseenter = () => {
          btns.style.backgroundColor = "#000";
          btns.style.color = "#fff";
        };
        btns.onmouseleave = () => {
          btns.style.backgroundColor = "#fff";
          btns.style.color = "#000";
        };
      }
    });

    mainCards.forEach((cards) => {
      if (cards) {
        cards.style.borderColor = "#fff";
      }
    });

    tableCells.forEach((cell) => {
      cell.style.borderColor = "#fff";
    });

    lightMode.textContent = "Light Mode";
    darkMode = true;
    // document.body.classList.remove("light-theme");
  }
});

const showBtn = document.getElementById("showBtn");
