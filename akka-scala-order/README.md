
### WHO to collect contry stat -> then Define Vaccine required -> then Notify contry 
### 

```aidl
Maheshs-MacBook-Pro:akka-scala-order mahesh$ sbt run
[info] welcome to sbt 1.4.6 (AdoptOpenJDK Java 13.0.2)
[info] loading global plugins from /Users/mahesh/.sbt/1.0/plugins
[info] loading settings for project akka-scala-order-build from plugins.sbt ...
[info] loading project definition from /Users/mahesh/play/scala-akka/akka-scala-order/project
[info] loading settings for project root from build.sbt ...
[info] set current project to akka_order (in build file:/Users/mahesh/play/scala-akka/akka-scala-order/)
[info] compiling 1 Scala source to /Users/mahesh/play/scala-akka/akka-scala-order/target/scala-2.13/classes ...
[info] running io.mahesh.Main 
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also http://www.slf4j.org/codes.html#replay
[2021-06-22 18:46:42,469] [INFO] [akka.event.slf4j.Slf4jLogger] [collector-akka.actor.default-dispatcher-3] [] - Slf4jLogger started
Country(US,100)
[2021-06-22 18:46:42,518] [INFO] [io.mahesh.WhoCollector$] [collector-akka.actor.default-dispatcher-3] [akka://collector/user] - Country(US,100)
Country(SG,100)
[2021-06-22 18:46:42,519] [INFO] [io.mahesh.VaccineDistributor$] [collector-akka.actor.default-dispatcher-6] [akka://collector/user/vaccine] - Vaccine(US,100,Actor[akka://collector/user/notifer#620337547])
Country(SL,100)
[2021-06-22 18:46:42,520] [INFO] [io.mahesh.WhoCollector$] [collector-akka.actor.default-dispatcher-3] [akka://collector/user] - Country(SG,100)
[2021-06-22 18:46:42,520] [INFO] [io.mahesh.VaccineDistributor$] [collector-akka.actor.default-dispatcher-6] [akka://collector/user/vaccine] - Vaccine(SG,100,Actor[akka://collector/user/notifer#620337547])
[2021-06-22 18:46:42,520] [INFO] [io.mahesh.Notifer$] [collector-akka.actor.default-dispatcher-5] [akka://collector/user/notifer] - Notification(New shipment of vaccine to US,100)
[2021-06-22 18:46:42,520] [INFO] [io.mahesh.Notifer$] [collector-akka.actor.default-dispatcher-5] [akka://collector/user/notifer] - Notification(New shipment of vaccine to SG,100)
[2021-06-22 18:46:42,520] [INFO] [io.mahesh.WhoCollector$] [collector-akka.actor.default-dispatcher-3] [akka://collector/user] - Country(SL,100)
[2021-06-22 18:46:42,521] [INFO] [io.mahesh.VaccineDistributor$] [collector-akka.actor.default-dispatcher-5] [akka://collector/user/vaccine] - Vaccine(SL,100,Actor[akka://collector/user/notifer#620337547])
[2021-06-22 18:46:42,521] [INFO] [io.mahesh.Notifer$] [collector-akka.actor.default-dispatcher-3] [akka://collector/user/notifer] - Notification(New shipment of vaccine to SL,100)


```