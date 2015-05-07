import play.Project._

name := """staffingrest"""

version := "1.0-SNAPSHOT"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.33",
  "net.sf.flexjson" % "flexjson" % "3.2",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  javaCore,
  javaJdbc,
  javaEbean,
  filters,
  cache)

playJavaSettings

resolvers += "google-sedis-fix" at "http://pk11-scratch.googlecode.com/svn/trunk/"

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

doc in Compile <<= target.map(_ / "none")