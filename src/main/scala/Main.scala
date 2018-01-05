import org.apache.ftpserver.FtpServerFactory
import org.apache.ftpserver.ftplet.User
import org.apache.ftpserver.listener.ListenerFactory
import org.apache.ftpserver.usermanager.UserFactory

object Main {
  val PortNumber = 2222
  def main(args: Array[String]): Unit = {
    val serverFactory = new FtpServerFactory
    addUser(serverFactory, createUser())
    setPort(serverFactory, PortNumber)
    val server = serverFactory.createServer()
    server.start()
  }

  def setPort(serverFactory: FtpServerFactory, port: Int): Unit = {
    val factory = new ListenerFactory()
    factory.setPort(port)
    serverFactory.addListener("default", factory.createListener())
  }

  def addUser(factory: FtpServerFactory, user: User): Unit = {
    val userManager = factory.getUserManager
    userManager.save(user)
  }

  def createUser(): User = {
    val userFactory = new UserFactory
    userFactory.setName("ponkotuy")
    userFactory.setPassword("password")
    userFactory.createUser()
  }
}
