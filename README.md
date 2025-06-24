java -version
java version "24.0.1" 2025-04-15
Java(TM) SE Runtime Environment (build 24.0.1+9-30)
Java HotSpot(TM) 64-Bit Server VM (build 24.0.1+9-30, mixed mode, sharing)
 
 
 # My First Git Repo

PS C:\workspace\gradle\TcpServerExample> ./gradlew clean build
WARNING: A restricted method in java.lang.System has been called
WARNING: java.lang.System::load has been called by net.rubygrapefruit.platform.internal.NativeLibraryLoader in an unnamed module (file:/C:/Users/user/.gradle/wrapper/dists/gradle-8.14-bin/38aieal9i53h9rfe7vjup95b9/gradle-8.14/lib/native-platform-0.22-milestone-28.jar)
WARNING: Use --enable-native-access=ALL-UNNAMED to avoid a warning for callers in this module
WARNING: Restricted methods will be blocked in a future release unless native access is enabled


Welcome to Gradle 8.14!

Here are the highlights of this release:
 - Java 24 support
 - GraalVM Native Image toolchain selection
 - Enhancements to test reporting
 - Build Authoring improvements

For more details see https://docs.gradle.org/8.14/release-notes.html


BUILD SUCCESSFUL in 1m 4s
4 actionable tasks: 4 executed



PS C:\workspace\gradle\TcpServerExample\build\libs> java -jar TcpServerExample-1.0-SNAPSHOT.jar           
Server listening on port 5000...
Client connected: /0:0:0:0:0:0:0:1
Raw received: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
one   : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
two   : aaaaaaaaaaaaaaaaaaaa
three : aaaaaaa
