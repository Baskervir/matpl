document.addEventListener("DOMContentLoaded", () => {
  const modalOverlay = document.querySelector(".modal_overlay");

  function openModal(modalSelector) {
    const modal = document.querySelector(modalSelector);
    if (!modal) return;
    modal.style.display = "block";
    modalOverlay.style.display = "block";
  }

  function closeAllModals() {
    document.querySelectorAll(".modal_signup_login, .modal_user_setting, .error_modal").forEach(m => {
      m.style.display = "none";
    });
    modalOverlay.style.display = "none";
  }

  modalOverlay.addEventListener("click", closeAllModals);

  document.querySelectorAll("[data-modal-target]").forEach(btn => {
    const target = btn.getAttribute("data-modal-target");
    btn.addEventListener("click", () => openModal(target));
  });
});

//document.querySelectorAll(".user_menu a").forEach(link => {
//    link.addEventListener("click", function (e) {
//        e.preventDefault();
//        const url = this.getAttribute("href");
//
//        fetch(url)
//            .then(res => res.text())
//            .then(html => {
//                document.getElementById("detail-container").innerHTML = html;
//            });
//    });
//});




//const modalOverlay = document.querySelector(".modal_overlay");
//
//function openModal(modalSelector) {
//    const modal = document.querySelector(modalSelector);
//    if (!modal) return;
//    modal.style.display = "block";
//    modalOverlay.style.display = "block";
//}
//
//modalOverlay.addEventListener("click", () => {
//    document.querySelectorAll("..modal_signup&login, .modal_user_setting, .error_modal").forEach(m => {
//        m.style.display = "none";
//    });
//    modalOverlay.style.display = "none";
//    error_modalOverlay.style.display = "none";
//});
//
//const openModalBtn = document.querySelector(".open-modal");
//if (openModalBtn) {
//    openModalBtn.addEventListener("click", () => openModal("..modal_signup&login"));
//}
//
//const settingsBtn = document.querySelector(".settings_btn");
//if (settingsBtn) {
//    settingsBtn.addEventListener("click", () => openModal(".modal_user_setting"));
//}
//
//const loginError = "{{loginError}}";
//
//if (loginError && loginError.trim() !== "") {
//  window.addEventListener("DOMContentLoaded", () => {
//    document.querySelector(".error_modal").style.display = "block";
//    document.querySelector(".error_modalOverlay").style.display = "block";
//  });
//}
