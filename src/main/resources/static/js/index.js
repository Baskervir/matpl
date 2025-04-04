const modalOverlay = document.querySelector(".modal_overlay");

function openModal(modalSelector) {
    const modal = document.querySelector(modalSelector);
    if (!modal) return;
    modal.style.display = "block";
    modalOverlay.style.display = "block";
}

modalOverlay.addEventListener("click", () => {
    document.querySelectorAll(".modal, .modal_user_setting").forEach(m => {
        m.style.display = "none";
    });
    modalOverlay.style.display = "none";
});

const openModalBtn = document.querySelector(".open-modal");
if (openModalBtn) {
    openModalBtn.addEventListener("click", () => openModal(".modal"));
}

const settingsBtn = document.querySelector(".settings_btn");
if (settingsBtn) {
    settingsBtn.addEventListener("click", () => openModal(".modal_user_setting"));
}

//function login_basic() {
//    let header = document.querySelector(".open-modal");
//    header.parentNode.removeChild(header);
//
//    modal.style.display = "none";
//    modalOverlay.style.display = "none";
//
//    let newP = document.createElement("p");
//    newP.innerHTML = `Basic_user1`;
//    document.querySelector(".login_signup_text").appendChild(newP);
//
//    let newBtn = document.createElement("button");
//    newBtn.innerHTML = `⚙️`;
//    document.querySelector(".login_signup_text").appendChild(newBtn);
//    newBtn.setAttribute("class", "setting_btn");
//}
//
//function login_admin() {
//    let header = document.querySelector(".open-modal");
//    header.parentNode.removeChild(header);
//
//    modal.style.display = "none";
//    modalOverlay.style.display = "none";
//
//    let newP = document.createElement("p");
//    newP.innerHTML = `Admin_user1`;
//    document.querySelector(".login_signup_text").appendChild(newP);
//
//    let newBtn = document.createElement("button");
//    newBtn.innerHTML = `⚙️`;
//    document.querySelector(".login_signup_text").appendChild(newBtn);
//    newBtn.setAttribute("class", "setting_btn");
//}
//
//function login_root() {
//    let header = document.querySelector(".open-modal");
//    header.parentNode.removeChild(header);
//
//    modal.style.display = "none";
//    modalOverlay.style.display = "none";
//
//    let newP = document.createElement("p");
//    newP.innerHTML = `Root_user1`;
//    document.querySelector(".login_signup_text").appendChild(newP);
//
//    let newBtn = document.createElement("button");
//    newBtn.innerHTML = `⚙️`;
//    document.querySelector(".login_signup_text").appendChild(newBtn);
//    newBtn.setAttribute("class", "setting_btn");
//}