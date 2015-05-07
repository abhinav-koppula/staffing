// Comment to get more information during initialization
logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "sbt-releases-repo" at  "http://repo.typesafe.com/typesafe/ivy-releases/"

resolvers += "sbt-plugins-repo" at "http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"

resolvers += "maven-central" at "http://repo1.maven.org/maven2/"

resolvers += "Typesafe Maven Repository" at "http://repo.typesafe.com/typesafe/maven-releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.2")

  