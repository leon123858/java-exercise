all:
	echo "do nothing"

testJava:
	mkdir "tmpTest" || true
	rsync -a "test/" "tmpTest"
	rsync -a "src/" "tmpTest"
	cd "tmpTest" && javac *.java
	cp "test.js" "tmpTest/test.js"
	cd tmpTest && node test.js "java Main ./sample1.in" "./sample1.out" || true
	rm -rf "tmpTest"

testJavas:
	mkdir "tmpTest" || true
	rsync -a "test/" "tmpTest"
	rsync -a "src/" "tmpTest"
	cd "tmpTest" && javac *.java
	cp "test.js" "tmpTest/test.js"
	cd tmpTest && node test.js "java LibrarySystem ./sample1.in" "./sample1.out" || true
	cd tmpTest && node test.js "java LibrarySystem ./sample2.in" "./sample2.out" || true
	rm -rf "tmpTest"