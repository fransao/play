name := """play-cache"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

//resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.11.0"

libraryDependencies += guice
libraryDependencies += evolutions
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test

libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0"
libraryDependencies += "com.h2database" % "h2" % "1.4.196"

libraryDependencies += ehcache
libraryDependencies += jcache
libraryDependencies += "org.jsr107.ri" % "cache-annotations-ri-guice" % "1.0.0"

routesGenerator := InjectedRoutesGenerator