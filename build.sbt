name := """Fagsamling"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.xerial"                            % "sqlite-jdbc"               % "3.7.2",
  "com.google.inject" % "guice" % "3.0",
  "mysql"                                 %  "mysql-connector-java"     % "5.1.18",
  "org.commonjava.googlecode.markdown4j"  % "markdown4j"                % "2.2-cj-1.0"
)
