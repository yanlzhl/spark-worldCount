name := "helloworld"

version := "1.0"

scalaVersion := "2.11.8"

assemblyMergeStrategy in assembly := {
  case PathList("org", "apache", xs @ _*)         => MergeStrategy.first
  case PathList("javax", "inject", xs @ _*)         => MergeStrategy.first
  case PathList("org", "aopalliance", xs @ _*)         => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith "axiom.xml" => MergeStrategy.filterDistinctLines
  case PathList(ps@_*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0"

libraryDependencies += "org.elasticsearch" % "elasticsearch-hadoop" % "6.0.0-rc2"

//libraryDependencies += "com.github.scopt" %% "scopt" % "3.3.0"
//
//libraryDependencies += "joda-time" % "joda-time" % "2.9.9"