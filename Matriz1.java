
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LIVEZONE - Streaming en vivo</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    background: #0b0b0e;
    color: white;
    font-family: Arial, sans-serif;
}

header {
    height: 75px;
    background: #111115;
    border-bottom: 1px solid #29292e;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 5%;
}

.logo {
    font-size: 25px;
    font-weight: bold;
    color: #ff3030;
}

.logo span {
    color: white;
}

.live {
    background: #ff3030;
    padding: 9px 17px;
    border-radius: 6px;
    font-weight: bold;
}

.container {
    width: 90%;
    max-width: 1400px;
    margin: 35px auto;
}

h1 {
    font-size: 27px;
    margin-bottom: 10px;
}

.subtitle {
    color: #999;
    margin-bottom: 25px;
}

.content {
    display: grid;
    grid-template-columns: 1fr 330px;
    gap: 22px;
}

.video-section {
    background: #17171c;
    border-radius: 12px;
    overflow: hidden;
    border: 1px solid #303038;
}

.video-box {
    background: #050507;
    width: 100%;
    aspect-ratio: 16/9;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
}

video {
    width: 100%;
    height: 100%;
    object-fit: contain;
}

.placeholder {
    position: absolute;
    text-align: center;
    color: #777;
}

.placeholder .icon {
    font-size: 55px;
    margin-bottom: 15px;
}

.status {
    position: absolute;
    top: 18px;
    left: 18px;
    background: #ff3030;
    padding: 7px 12px;
    border-radius: 5px;
    font-size: 12px;
    font-weight: bold;
    display: none;
}

.video-info {
    padding: 20px;
}

.video-info h2 {
    font-size: 21px;
    margin-bottom: 8px;
}

.video-info p {
    color: #999;
    font-size: 14px;
}

.controls {
    display: flex;
    flex-wrap: wrap;
    gap: 12px;
    padding: 0 20px 20px;
}

button {
    border: none;
    padding: 12px 17px;
    border-radius: 7px;
    background: #292930;
    color: white;
    cursor: pointer;
    font-size: 14px;
    transition: .2s;
}

button:hover {
    opacity: .8;
    transform: translateY(-2px);
}

.start {
    background: #ff3030;
}

.stop {
    background: #444;
}

.chat {
    background: #17171c;
    border: 1px solid #303038;
    border-radius: 12px;
    display: flex;
    flex-direction: column;
    min-height: 450px;
}

.chat-header {
    padding: 20px;
    border-bottom: 1px solid #303038;
    font-size: 18px;
    font-weight: bold;
}

.messages {
    flex: 1;
    padding: 15px;
    overflow-y: auto;
    max-height: 400px;
}

.message {
    margin-bottom: 15px;
    font-size: 14px;
    overflow-wrap: anywhere;
}

.message strong {
    color: #ff5555;
}

.chat-input {
    display: flex;
    gap: 8px;
    padding: 12px;
    border-top: 1px solid #303038;
}

.chat-input input {
    min-width: 0;
    flex: 1;
    background: #25252b;
    border: none;
    border-radius: 6px;
    padding: 12px;
    color: white;
    outline: none;
}

.chat-input button {
    background: #ff3030;
}

.stream-settings {
    background: #17171c;
    padding: 20px;
    border: 1px solid #303038;
    border-radius: 10px;
    margin-top: 22px;
}

.stream-settings h3 {
    margin-bottom: 15px;
}

.stream-settings input {
    width: 100%;
    padding: 13px;
    border-radius: 6px;
    background: #25252b;
    border: 1px solid #38383f;
    color: white;
    margin-bottom: 12px;
    outline: none;
}

footer {
    text-align: center;
    padding: 30px;
    color: #666;
    font-size: 13px;
}

@media(max-width: 850px) {
    .content {
        grid-template-columns: 1fr;
    }

    .chat {
        min-height: 350px;
    }

    header {
        padding: 0 5%;
    }

    .container {
        width: 94%;
    }
}
</style>
</head>

<body>

<header>
    <div class="logo">LIVE<span>ZONE</span></div>
    <div class="live">● EN VIVO</div>
</header>

<div class="container">

    <h1>Tu espacio de streaming</h1>
    <p class="subtitle">Comparte tus momentos y transmite en directo.</p>

    <div class="content">

        <section>

            <div class="video-section">

                <div class="video-box">

                    <video id="video" autoplay muted playsinline></video>

                    <div class="placeholder" id="placeholder">
                        <div class="icon">📹</div>
                        <h3>Tu transmisión aparecerá aquí</h3>
                        <p>Activa tu cámara para comenzar</p>
                    </div>

                    <div class="status" id="status">● EN VIVO</div>

                </div>

                <div class="video-info">
                    <h2 id="streamTitle">Mi primera transmisión</h2>
                    <p>Transmisión personal de LIVEZONE</p>
                </div>

                <div class="controls">
                    <button class="start" onclick="startCamera()">
                        📹 Activar cámara
                    </button>

                    <button onclick="startScreen()">
                        🖥 Compartir pantalla
                    </button>

                    <button onclick="toggleMic()">
                        🎙 Silenciar micrófono
                    </button>

                    <button class="stop" onclick="stopStream()">
                        ⏹ Detener
                    </button>
                </div>

            </div>

            <div class="stream-settings">
                <h3>⚙ Configuración de transmisión</h3>

                <input
                    type="text"
                    id="titleInput"
                    placeholder="Nombre de tu transmisión"
                >

                <button class="start" onclick="changeTitle()">
                    Guardar título
                </button>
            </div>

        </section>

        <aside class="chat">

            <div class="chat-header">
                💬 Chat en vivo
            </div>

            <div class="messages" id="messages">
                <div class="message">
                    <strong>LIVEZONE:</strong>
                    ¡Bienvenido al chat!
                </div>
                <div class="message">
                    <strong>Sistema:</strong>
                    Disfruta de la transmisión.
                </div>
            </div>

            <div class="chat-input">
                <input
                    type="text"
                    id="chatInput"
                    placeholder="Escribe un mensaje..."
                >

                <button onclick="sendMessage()">Enviar</button>
            </div>

        </aside>

    </div>

</div>

<footer>
    LIVEZONE © 2026 - Tu plataforma de transmisiones
</footer>

<script>

const video = document.getElementById("video");
const placeholder = document.getElementById("placeholder");
const statusLabel = document.getElementById("status");

let stream = null;
let micEnabled = true;

async function startCamera() {

    try {

        stopStream();

        stream = await navigator.mediaDevices.getUserMedia({
            video: true,
            audio: true
        });

        video.srcObject = stream;

        placeholder.style.display = "none";
        statusLabel.style.display = "block";

        micEnabled = true;

    } catch (error) {

        alert("No se pudo activar la cámara o el micrófono. Revisa los permisos.");

    }

}

async function startScreen() {

    try {

        stopStream();

        stream = await navigator.mediaDevices.getDisplayMedia({
            video: true,
            audio: true
        });

        video.srcObject = stream;

        placeholder.style.display = "none";
        statusLabel.style.display = "block";

        stream.getVideoTracks()[0].onended = stopStream;

    } catch (error) {

        alert("No se pudo compartir la pantalla.");

    }

}

function toggleMic() {

    if (!stream) {
        alert("Primero activa la cámara.");
        return;
    }

    const audioTracks = stream.getAudioTracks();

    if (audioTracks.length === 0) {
        alert("No hay micrófono disponible en esta fuente.");
        return;
    }

    micEnabled = !micEnabled;

    audioTracks.forEach(track => {
        track.enabled = micEnabled;
    });

}

function stopStream() {

    if (stream) {
        stream.getTracks().forEach(track => track.stop());
        stream = null;
    }

    video.srcObject = null;

    placeholder.style.display = "block";
    statusLabel.style.display = "none";

}

function changeTitle() {

    const title = document.getElementById("titleInput").value.trim();

    if (title !== "") {
        document.getElementById("streamTitle").textContent = title;
    }

}

function sendMessage() {

    const input = document.getElementById("chatInput");
    const messages = document.getElementById("messages");

    const message = input.value.trim();

    if (message === "") return;

    const div = document.createElement("div");
    div.className = "message";

    const username = document.createElement("strong");
    username.textContent = "Tú: ";

    div.appendChild(username);
    div.appendChild(document.createTextNode(message));

    messages.appendChild(div);

    input.value = "";
    messages.scrollTop = messages.scrollHeight;

}

document.getElementById("chatInput").addEventListener("keydown", function(e) {
    if (e.key === "Enter") sendMessage();
});

</script>

</body>
</html>
