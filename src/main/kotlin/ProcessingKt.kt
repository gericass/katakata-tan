import processing.core.PApplet
import py4j.GatewayServer


class ProcessingKt : PApplet() {

    var a = 200f
    var b = 1f
    override fun settings() {
        size(600, 600, P3D)
    }

    override fun setup() {

    }

    override fun draw() {

        noFill()
        background(0f, 0f, 0f)
        ambientLight(123f, 55f, 67f)
        directionalLight(123f, 55f, 67f, 0f, 0f, 50f)
        strokeWeight(4f)
        stroke(a - 900, a, a * 9, 20f)
        //rotateY(20f)
        translate(width / 2f, height / 2f, 0f)
        rotateY(radians(b))
        rotateX(mouseY.toFloat() / 10f)
        sphere(a - 50)
        fill(10f, 10f)
        filter(BLUR, 0.2f)
        rotate(b)
        b += 1f
    }

    fun run(): Unit
            = PApplet.main("ProcessingKt")
}

fun main(args: Array<String>) {
    // app を gateway.entry_point に設定
    val app = ProcessingKt()
    val server = GatewayServer(app)
    server.start()
    System.out.println("Gateway Server Started")
    //ProcessingKt().run()
}