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
if (showSkillBtn) {
  showSkillBtn.addEventListener("click", () => {
    if (skills.style.display === "none") {
      skills.style.display = "block";
      showSkillBtn.textContent = "Hide";
    } else {
      skills.style.display = "none";
      showSkillBtn.textContent = "Show";
    }
  });
}

//dark-light
let darkMode = false;

document.addEventListener("click", (event) => {
  const lightMode = event.target.closest("#light-mode");

  if (!lightMode) return;

  const mainBtns = [
    document.querySelector(".subscribe-btn"),
    document.querySelector("#about-me-btn"),
    document.querySelector("#show-skills-btn"),
    document.querySelector(".submit-form"),
    document.querySelector(".reset-form"),
    document.querySelector("#show-skills"),
    document.querySelector("#github-repos"),
  ];

  const mainCards = [
    document.querySelector("#email-field"),
    document.querySelector("#about-me"),
    document.querySelector("#left-about"),
    document.querySelector("#mid-about"),
    document.querySelector("#right-about"),
    document.querySelector("#curr-proj-1"),
    document.querySelector("#curr-proj-2"),
    document.querySelector("#contact-form"),
  ];

  const tableCells = document.querySelectorAll(
    "#project-table th, #project-table td"
  );

  const anchorTags = document.querySelectorAll(
    "#view-more, .table-links, .nav-lnks, #right-about a, .site-nav a"
  );
  if (!darkMode) {
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

    anchorTags.forEach((links) => {
      if (links) {
        links.onmouseenter = () => {
          links.style.color = "#fff";
        };
        links.onmouseleave = () => {
          links.style.color = "#000";
        };
      }
    });

    lightMode.textContent = "Dark Mode";
    darkMode = true;
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

    anchorTags.forEach((links) => {
      if (links) {
        links.onmouseenter = () => {
          links.style.color = "#000";
        };

        links.onmouseleave = () => {
          links.style.color = "#fff";
        };
      }
    });
    lightMode.textContent = "Light Mode";
    darkMode = false;
    // document.body.classList.remove("light-theme");
  }
});

const showBtn = document.getElementById("showBtn");

const loadRepos = document.getElementById("github-repos");
async function gitRepos(url) {
  try {
    const repo = await fetch(url);
    if (!repo.ok) {
      throw new Error(`invalid api url status: ${repo.status}`);
    }
    return await repo.json();
  } catch (error) {
    console.error(error.message);
    return null;
  }
}

const repoError = document.getElementById("error-repo");
if (loadRepos) {
  loadRepos.addEventListener("click", async () => {
    const repoData = await gitRepos(
      "https://api.github.com/users/SatyamBhosale2004/repos"
    );

    if (!repoData) {
      repoError.textContent = "Failed to load repos";
      return;
    } else repoError.style.display = "none";
    const list = document.getElementById("repo-list");
    if (!list) return;
    list.innerHTML = "";
    for (const repo of repoData) {
      const item = document.createElement("li");
      const repoLink = document.createElement("a");
      repoLink.textContent = repo.name;
      repoLink.href = repo.html_url;
      repoLink.target = "_blank";
      repoLink.rel = "noopener noreferrer";
      item.appendChild(repoLink); //li
      list.appendChild(item); //ul
    }
  });
}

const projects = [
  {
    id: 1,
    tech: ["Next.js", "Express.js", "AWS", "Razorpay"],
    title: "Falsenine",
    description:
      "A serverless e-commerce platform with REST APIs and online payment integration.",
    link: "https://github.com/SatyamBhosale2004/falsenine_client",
    demoLink: "",
  },
  {
    id: 2,
    tech: ["React.js", "Express.js", "Chrome APIs", "AI/LLM"],
    title: "Locus",
    tagline: "Less tab chaos. More focus.",
    description:
      "An AI-powered browser tab manager for organizing tabs and restoring browsing sessions.",
    link: "https://github.com/SatyamBhosale2004/locus_ui",
    demoLink: "",
  },
  {
    id: 3,
    tech: ["Next.js", "Tailwind Css", "GSAP"],
    title: "Enclave",
    tagline: "Secrets management for developers.",
    description:
      "	A developer tool showcasing the frontend interface for a Git-like application secrets manager, with backend versioning workflows in development.",
    link: "https://github.com/SatyamBhosale2004/enclave-frontend",
    demoLink: "https://enclave-frontend-kappa.vercel.app/",
  },
  {
    id: 4,
    tech: [
      "Next.js",
      "Express.js",
      "Blockchain",
      "Solidity",
      "IPFS",
      "Decentralized Identity (DID)",
    ],
    title: "Recuris",
    description:
      "Recuris is a decentralized, blockchain-powered EHR platform that uses smart contracts, IPFS, and DIDs to ensure secure, patient-controlled, and interoperable global health data access.",
    link: "https://github.com/SatyamBhosale2004/recuris",
    demoLink: "",
  },
  {
    id: 5,
    tech: ["HTML", "CSS"],
    title: "Sol&Sip",
    description:
      "A branded landing page for Sol&Sip, built as part of the WPT Assignment 1 project.",
    link: "https://github.com/SatyamBhosale2004/cdac_assignment/tree/main/wpt/assignment-1/landing-page",
    demoLink: "https://cdacassignment-landing-page.vercel.app/",
  },
];

class Project {
  constructor(id, tech, title, description, link, demoLink) {
    this.id = id;
    this.tech = tech;
    this.title = title;
    this.description = description;
    this.link = link;
    this.demoLink = demoLink;
  }

  getSummary() {
    return this.tagline;
  }
}

class FeaturedProject extends Project {
  constructor(id, tech, title, description, link, demoLink, badge,tagline) {
    super(id, tech, title, description, link, demoLink);
    this.badge = badge;
    this.tagline=tagline;
  }
}

const projectsInstance = projects.map(
  ({ id, tech, title, description, link, demoLink }) =>
    new Project(id, tech, title, description, link, demoLink)
);

const projectBody = document.getElementById("project-body");

if (projectBody) {
  projectBody.innerHTML = "";

  for (const {
    id,
    tech,
    title,
    description,
    link,
    demoLink,
  } of projectsInstance) {
    const row = document.createElement("tr");
    const idCell = document.createElement("td");
    const techCell = document.createElement("td");
    const titleCell = document.createElement("td");
    const descriptionCell = document.createElement("td");
    const linkCell = document.createElement("td");
    idCell.textContent = id;
    row.appendChild(idCell);
    projectBody.appendChild(row);
    titleCell.textContent = title;
    row.appendChild(titleCell);
    projectBody.appendChild(row);
    techCell.textContent = tech.join(", ");
    row.appendChild(techCell);
    projectBody.appendChild(row);
    descriptionCell.textContent = description;
    row.appendChild(descriptionCell);
    projectBody.appendChild(row);
    const demoUrl = demoLink?.trim() ?? "";
    const projectLink = demoUrl || link;
    const sourceLink = document.createElement("a");
    sourceLink.classList.add("table-links");
    sourceLink.textContent = demoUrl ? "Link" : "Source Code";
    sourceLink.href = projectLink;
    sourceLink.target = "_blank";
    sourceLink.rel = "noopener noreferrer";
    linkCell.appendChild(sourceLink);
    row.appendChild(linkCell);
    projectBody.appendChild(row);
  }
}

const locus = projects.find((p) => (p.title === "Locus"));
const enclave = projects.find((p) => (p.title === "Enclave"));

const featuredProjects = [
  new FeaturedProject(
    locus.id,
    locus.tech,
    locus.title,
    locus.description,
    locus.link,
    locus.demoLink,
    "Featured",
    locus.tagline
  ),
  new FeaturedProject(
    enclave.id,
    enclave.tech,
    enclave.title,
    enclave.description,
    enclave.link,
    enclave.demoLink,
    "Featured",
    enclave.tagline
  ),
];

const featuredContainer = document.getElementById("current-table");

if(featuredContainer){
  featuredContainer.innerHTML="";
  let cardNo = 1;
  for (const project of featuredProjects){
    const div = document.createElement("div"); 
    div.id=`curr-proj-${cardNo}`;
    cardNo++; 
    const titleElem = document.createElement("h1");
    const summaryElem = document.createElement("h3");
    const techElem = document.createElement("h3");
    const descriptionElem = document.createElement("p");
    const demoUrl = project.demoLink?.trim() ?? "";
    const projectLink = demoUrl || project.link;
    const projectLinkElem = document.createElement("a");
    titleElem.textContent = project.title;
    div.appendChild(titleElem);
    summaryElem.textContent = project.getSummary();
    div.appendChild(summaryElem);
    techElem.textContent = "Tech Stack: " + project.tech.join(", ");
    div.appendChild(techElem);
    descriptionElem.textContent = project.description;
    div.appendChild(descriptionElem);
    projectLinkElem.textContent = "Project Link";
    projectLinkElem.href=projectLink;
    projectLinkElem.target="_blank";
    projectLinkElem.rel="noopener noreferrer";
    div.appendChild(projectLinkElem);
    const badge = document.createElement("span");
    badge.textContent = project.badge;
    div.appendChild(badge);
    featuredContainer.appendChild(div);
    
  }
}