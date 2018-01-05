
name := "ScalaFTPServer"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.apache.ftpserver" % "ftpserver" % "1.1.1" pomOnly()
)
