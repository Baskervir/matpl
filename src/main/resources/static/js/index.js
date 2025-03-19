const openModalBttn = document.querySelector(".open-modal");
const modal = document.querySelector(".modal");
const modalOverlay = document.querySelector(".modal_overlay");

openModalBttn.addEventListener("click", function () {
    modal.style.display = "block";
    modalOverlay.style.display = "block";
});

modalOverlay.addEventListener('click', function () {
    modal.style.display = 'none';
    modalOverlay.style.display = 'none';
});

function login_basic() {
    let header = document.querySelector(".open-modal");
    header.parentNode.removeChild(header);

    modal.style.display = "none";
    modalOverlay.style.display = "none";

    let newP = document.createElement("p");
    newP.innerHTML = `Basic_user1`;
    document.querySelector(".login_signup_text").appendChild(newP);

    let newBtn = document.createElement("button");
    newBtn.innerHTML = `⚙️`;
    document.querySelector(".login_signup_text").appendChild(newBtn);
    newBtn.setAttribute("class", "setting_btn");
}

function login_admin() {
    let header = document.querySelector(".open-modal");
    header.parentNode.removeChild(header);

    modal.style.display = "none";
    modalOverlay.style.display = "none";

    let newP = document.createElement("p");
    newP.innerHTML = `Admin_user1`;
    document.querySelector(".login_signup_text").appendChild(newP);

    let newBtn = document.createElement("button");
    newBtn.innerHTML = `⚙️`;
    document.querySelector(".login_signup_text").appendChild(newBtn);
    newBtn.setAttribute("class", "setting_btn");
}

function login_root() {
    let header = document.querySelector(".open-modal");
    header.parentNode.removeChild(header);

    modal.style.display = "none";
    modalOverlay.style.display = "none";

    let newP = document.createElement("p");
    newP.innerHTML = `Root_user1`;
    document.querySelector(".login_signup_text").appendChild(newP);

    let newBtn = document.createElement("button");
    newBtn.innerHTML = `⚙️`;
    document.querySelector(".login_signup_text").appendChild(newBtn);
    newBtn.setAttribute("class", "setting_btn");
}