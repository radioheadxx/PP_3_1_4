// show info in modal

// on(document, 'click', '#editModal', e => {
//     const userInfo = e.target.parentNode.parentNode
//     document.getElementById('edId').value = userInfo.children[0].innerHTML
//     document.getElementById('edFirstname').value = userInfo.children[1].innerHTML
//     document.getElementById('edLastname').value = userInfo.children[2].innerHTML
//     document.getElementById('edEmail').value = userInfo.children[3].innerHTML
//     document.getElementById('editRole').value = userInfo.children[4].innerHTML
//     document.getElementById('edPassword').value = userInfo.children[5].innerHTML
//
//     $("#modalEdit").modal('show')
//
// })

const editModal = document.getElementById('editModal')
const modalUserId = editModal.querySelector('#edId')
const modalUserName = editModal.querySelector('#edFirstname')
const modalUserSurname = editModal.querySelector('#edLastname')
const modalUserAge = editModal.querySelector('#edAge')
const modalUserEmail = editModal.querySelector('#edEmail')

editModal.addEventListener('show.bs.modal', event => {
    const button = event.relatedTarget
    const userId = button.getAttribute('data-bs-userId')
    const userName = button.getAttribute('data-bs-userName')
    const userSurname = button.getAttribute('data-bs-userSurname')
    const userAge = button.getAttribute('data-bs-userAge')
    const userEmail = button.getAttribute('data-bs-userEmail')

     console.log("there is the name of user")
    console.log(userName)

    modalUserId.value = userId
    modalUserName.value = userName
    modalUserSurname.value = userSurname
    modalUserAge.value = userAge
    modalUserEmail.value = userEmail

})

// const editModal = document

