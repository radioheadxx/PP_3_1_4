
//  вывод в таблицу

async function getUsers() {

    fetch("/api")
        .then(res => {
            res.json().then(
                data => {
                    console.log(data);
                    if (data.length > 0) {
                        var temp = '';

                        //start for loop

                        data.forEach((user) => {
                            temp += "<tr>";
                            temp += "<td>" + user.id + "</td>";
                            temp += "<td>" + user.username + "</td>";
                            temp += "<td>" + user.surname + "</td>";
                            temp += "<td>" + user.age + "</td>";
                            temp += "<td>" + user.email + "</td>";
                            temp += `<td>${user.roles.map(roles => roles.name === 'ROLE_USER' ? 'USER' : 'ADMIN')}</td>`;
                            temp += `<td><button type="button" class="btn btn-info" style="color: white" data-toggle="modal" data-action="edit" data-userid="${user.id}" data-target="#editModal">Edit</button></td>`
                            temp += `<td><button type="button" class="btn btn-danger" style="color: white" data-toggle="modal" data-userid="${user.id}" data-action="delete" data-target="#deleteModal" >Delete</button></td></tr>`
                        })

                        //close for loop

                        document.getElementById('data').innerHTML = temp;
                    }
                }
            )
        })

    // обрабатываем нажатие на кнопку edit
    // достаем из нее данные и отдаем модалке, которую к тому же открываем
    $("#mainTableWithUsers").find('button').on('click', (event) => {
        let editModal = $('#editModal');
        let targetButton = $(event.target);
        let buttonUserId = targetButton.attr('data-userid');
        let buttonAction = targetButton.attr('data-action');

        editModal.attr('data-userid', buttonUserId);
        editModal.attr('data-action', buttonAction);
        editModal.modal('show');
    })

    // обрабатываем нажатие на кнопку delete

    $("#mainTableWithUsers").find('button').on('click', (event) => {
        let deleteModal = $('#deleteModal');
        let targetButton = $(event.target);
        let buttonUserId = targetButton.attr('data-userid');
        let buttonAction = targetButton.attr('data-action');

        deleteModal.attr('data-userid', buttonUserId);
        deleteModal.attr('data-action', buttonAction);
        deleteModal.modal('show');
    })
}
