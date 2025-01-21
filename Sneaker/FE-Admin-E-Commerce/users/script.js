document.addEventListener("DOMContentLoaded", function() {
    // Load Sidebar
    fetch("/components/sidebar.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("sidebar-container").innerHTML = data;
        });

    // Load Header
    fetch("/components/header.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("header-container").innerHTML = data;
        });

        // Fetch data from Spring Boot
    fetch('/api/users') // Replace with your Spring Boot API endpoint
            .then(response => response.json())
            .then(data => {
                    const tableBody = document.getElementById('user-table-body');
                    data.users.forEach(user => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.phoneNumber}</td>
                            <td>
                                <button class="btn edit-btn">Edit</button>
                                <button class="btn delete-btn">Delete</button>
                            </td>
                        `;
                        tableBody.appendChild(row);
                    });

                    // Update pagination info
                    document.getElementById('page-info').textContent = `Page ${data.page} of ${data.totalPages}`;
                })
                .catch(error => console.error('Error fetching users:', error));
                let currentPage = 0;
        let totalPages = 1;

        
        function fetchUsers(page) {
            fetch(`/api/users?page=${page}&size=8`) // Replace with your Spring Boot API endpoint
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.getElementById('user-table-body');
                    tableBody.innerHTML = ''; // Clear existing rows
                    data.content.forEach(user => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.phoneNumber}</td>
                            <td>
                                <button class="btn edit-btn">Edit</button>
                                <button class="btn delete-btn">Delete</button>
                            </td>
                        `;
                        tableBody.appendChild(row);
                    });

                    // Update pagination info
                    currentPage = data.pageable.pageNumber;
                    totalPages = data.totalPages;
                    document.getElementById('page-info').textContent = `Page ${currentPage + 1} of ${totalPages}`;
                    document.getElementById('prev-page').disabled = currentPage === 0;
                    document.getElementById('next-page').disabled = currentPage >= totalPages - 1;
                })
                .catch(error => console.error('Error fetching users:', error));
        }

        document.getElementById('prev-page').addEventListener('click', () => {
            if (currentPage > 0) {
                fetchUsers(currentPage - 1);
            }
        });

        document.getElementById('next-page').addEventListener('click', () => {
            if (currentPage < totalPages - 1) {
                fetchUsers(currentPage + 1);
            }
        });

        // document.getElementById('btn edit-btn').addEventListener('click', (event) => {
            
        //     fetch('/users/edit-user-form.html')
        // .then(response => {
        //     if (!response.ok) {
        //         throw new Error('Network response was not ok');
        //     }
        //     return response.text();
        // })
        // .then(html => {
        //     // Chèn nội dung HTML vào một phần tử có id 'content'
        //     document.getElementById('content').innerHTML = html;
        // })
        // .catch(error => {
        //     console.error('Error fetching the HTML:', error);
        // });
        // });

        // Initial fetch
        fetchUsers(currentPage);
});