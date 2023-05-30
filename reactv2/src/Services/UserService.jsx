const BASE_URL = "http://localhost:8080/api/usuario/";

export async function BuscarApi() {
  const res = await fetch(`${BASE_URL}allusers`);
  const data = await res.json();
  console.log(data);
  return data;
}

async function getAllUsers() {
  try {
    const response = await fetch(`${BASE_URL}allusers`);
    return await response.json();
  } catch (error) {
    console.error(error);
  }
}

async function getUserID(id) {
  try {
    const response = await fetch(`${BASE_URL}id/${id}`);
    return await response.json();
  } catch (error) {
    console.error(error);
  }
}

async function getUserEmail(email) {
  try {
    const response = await fetch(`${BASE_URL}email/${email}`);
    return await response.json();
  } catch (error) {
    console.error(error);
  }
}

async function deleteUser(id) {
  try {
    const response = await fetch(`${BASE_URL}${id}`, { method: "DELETE" });
    return await response.json();
  } catch (error) {
    console.error(error);
  }
}

async function createUser(user) {
  try {
    const response = await fetch(`${BASE_URL}`, {
      method: "POST",
      body: JSON.stringify(user),
      headers: { "Content-Type": "application/json" },
    });
    return await response.json();
  } catch (error) {
    console.error(error);
  }
}

export { getAllUsers, getUserID, deleteUser, createUser, getUserEmail };