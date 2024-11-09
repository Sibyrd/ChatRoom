const websocket = require("ws");
const server = new websocket.Server({ port: 8080 })


server.on("connection", socket => {
    let count = 0;
    let username;
    let currmessage;
    console.log("Connected: ", socket.id);
    socket.on("disconnect", () => {console.log("Disconnected: ", socket.id);});
    socket.on("message", message => {
        if (count===0) {
            username = message;
        } else {
            currmessage = `${username}: ${message}`;
            console.log(currmessage);
            server.clients.forEach(client => {
                client.send(currmessage);
            })
        }
    })
})