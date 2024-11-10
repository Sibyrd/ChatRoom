import { WebSocketServer } from 'ws';
const server = new WebSocketServer({ port: 1273 })
const discordwebhook = "URLHERE"
import fetch from "node-fetch";

server.on("connection", socket => {
    let count = 0;
    let username;
    let currmessage;
    console.log("Connected: ", socket.id);
    socket.on("close", () => {console.log("Disconnected: ", socket.id);});
    socket.on("message", message => {
        if (message == "") {
            console.log("Empty message - returning");
            return
        }
        if (count===0) {
            username = message;
            count++;
        } else {
            currmessage = `${username}: ${message}`;
            console.log(currmessage);
            server.clients.forEach(client => {
                client.send(currmessage);
            });
            var params = {
                embeds: [
                    {
                        "title": `New Message`,
                        "color": 9498256,
                        "thumbnail": {
                            "url": "",
                        },
                        "fields": [
                            {
                                "name": `${username}`,
                                "value": `${message}`,
                                "inline": true
                            }
                        ]
                    }
                ]
            };
            fetch(discordwebhook, {
                method: "POST",
                headers: {
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(params)
            }).then(res => {
                console.log(res);
            });
        }
    })
})

