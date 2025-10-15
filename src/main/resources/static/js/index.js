console.log("Hello, World!");
const descriptions = document.querySelectorAll('.description');
//console.log(descriptions);
descriptions.forEach(desc => {
    let filteredContent = desc.textContent.replace(/https?:\/\/[\w\-._~:/?#[\]@!$&'()*+,;=%]+/g, ' ').trim();
    desc.innerText = filteredContent;
    desc.addEventListener('click', () => {
        desc.classList.toggle('line-clamp-3');
        desc.classList.toggle('line-clamp-none');
    });
});

