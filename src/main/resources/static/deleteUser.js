const deleteModalForm = document.querySelector('.deleteModalForm')
const id = button.getAttribute('data-bs-userId')
console.log("ща мы удалим юзера с этим айди " + id)

deleteModalForm.addEventListener('submit', e => {
    e.preventDefault();

    fetch('api/' + id, {
        method: 'DELETE',
        })
    }).then(()=> getUsers())
    $("#deleteModal").modal("hide");
    deleteModalForm.reset()