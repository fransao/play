name := "calcularPi"

version := "0.1"

scalaVersion := "2.12.6"

// resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.sonatypeRepo("snapshots")

//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.13"
//libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.5.13"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.13"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.5.13"
// https://mvnrepository.com/artifact/voldemort.store.compress/h2-lzf
libraryDependencies += "voldemort.store.compress" %% "h2-lzf" % "1.0"
