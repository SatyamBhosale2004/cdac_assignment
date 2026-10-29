async function loadCommon(elementId, filePath) {
  const element = document.getElementById(elementId);

  if (!element) {
    console.error(`Missing element ${elementId}`);
    return;
  }

  try {
    const response = await fetch(filePath);

    if (!response.ok) {
      throw new Error(`${filePath} cant be loaded`);
    }
    element.innerHTML = await response.text();
  } catch (error) {
    console.error(error);
    element.textContent = "Page can't be loaded";
  }
}

loadCommon("train-scene", "train-scene.html");
loadCommon("navbar", "nav.html");
