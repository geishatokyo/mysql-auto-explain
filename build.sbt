lazy val commonSettings = Seq(
  organization := "com.geishatokyo",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.11.8"
)

lazy val root = project.in(file(".")).settings(commonSettings: _*).
  settings(
    name := "mysql-auto-explain"
  ).aggregate(core,forScalikeJdbc)


lazy val core = project.in(file("core")).settings(commonSettings: _*).
  settings(
    name:= "mysql-auto-explain-core",
    libraryDependencies ++= Seq(
      "mysql" % "mysql-connector-java" % "5.1.23" % "provided"
    )
  )

lazy val forScalikeJdbc = project.in(file("scalikejdbc")).settings(commonSettings: _*).
  settings(
    name := "mysql-auto-explain-scalikejdbc",
    libraryDependencies ++= Seq(
      "org.scalikejdbc" %% "scalikejdbc"       % "2.4.2",
      "ch.qos.logback"  %  "logback-classic"   % "1.1.7" % "provided"
    )
  ).dependsOn(core)
