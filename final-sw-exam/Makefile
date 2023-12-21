all:
	echo "do nothing"

testJava:
	mkdir "tmpTest" || true
	rsync -a "test/" "tmpTest"
	rsync -a "src/" "tmpTest"
	cd "tmpTest" && javac *.java
	cp "test.js" "tmpTest/test.js"
	cd tmpTest && node test.js "java Main ./sample7.in" "./sample7.out" || true
	rm -rf "tmpTest"

testJavas:
	mkdir "tmpTest" || true
	rsync -a "test/" "tmpTest"
	rsync -a "src/" "tmpTest"
	cd "tmpTest" && javac *.java
	cp "test.js" "tmpTest/test.js"
	cd tmpTest && node test.js "java Main ./sample1.in" "./sample1.out" || true
	cd tmpTest && node test.js "java Main ./sample2.in" "./sample2.out" || true
	cd tmpTest && node test.js "java Main ./sample3.in" "./sample3.out" || true
	cd tmpTest && node test.js "java Main ./sample4.in" "./sample4.out" || true
	cd tmpTest && node test.js "java Main ./sample5.in" "./sample5.out" || true
	cd tmpTest && node test.js "java Main ./sample6.in" "./sample6.out" || true
	cd tmpTest && node test.js "java Main ./sample7.in" "./sample7.out" || true
	rm -rf "tmpTest"