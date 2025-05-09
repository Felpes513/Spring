const apiBase = 'http://localhost:8080/projeto/v1/usuarios';

document.getElementById('userForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const usuario = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value,
        tipo: document.getElementById('tipo').value
    };

    try {
        await fetch(apiBase, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(usuario)
        });
        loadUsuarios();
        e.target.reset();
    } catch (error) {
        alert('Erro ao cadastrar usuário');
    }
});

async function loadUsuarios() {
    const response = await fetch(apiBase);
    const usuarios = await response.json();

    const tbody = document.getElementById('userTable');
    tbody.innerHTML = '';

    usuarios.forEach(usuario => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
      <td>${usuario.id}</td>
      <td>${usuario.nome}</td>
      <td>${usuario.email}</td>
      <td>${usuario.tipo}</td>
      <td>
        <button onclick="deletarUsuario(${usuario.id})">Excluir</button>
      </td>
    `;
        tbody.appendChild(tr);
    });
}

async function deletarUsuario(id) {
    if (confirm('Tem certeza que deseja excluir este usuário?')) {
        await fetch(`${apiBase}/${id}`, { method: 'DELETE' });
        loadUsuarios();
    }
}

window.onload = loadUsuarios;
