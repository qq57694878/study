import groovy.io.FileType

/**
 * Created by Administrator on 2017/5/26.
 */
baseDir="E:\\ideaw1\\mystudy\\groovydemo";
new File(baseDir, 'haiku.txt').eachLine { line, nb ->
    println "Line $nb: $line"
}

class A{
    int a;
    int b;
    int add(){
        this.a+this.b;
    }
}
A a = new A();
a.a=1;
a.b=2;
System.out.println(a.add());

public class Y {
    public class X {}
    public X foo() {
        return new X();
    }
    public static X createX(Y y) {
        return  X(y);
    }
}
Runnable run = {System.out.println("Run");}
list = new ArrayList();
list.add(1);
list.add(2);
list.each {i -> println i}
long i
m(i)

void m(long l) {
    println "in m(long)"
}

void m(Integer i) {
    println "in m(Integer)"
}
class C extends A{

}
class D extends A{

}
A c = new C();
A d = new C();
println c==d;

def list = new File(baseDir, 'haiku.txt').collect {it}
println list;

/*new File(baseDir,'haiku.txt') << '''Into the ancient pond
A frog jumps
Water’s sound!'''*/
/*def dir = new File(baseDir);
dir.eachFile { file ->
    println file.name
}

dir.eachFileRecurse(FileType.FILES) { file ->
    println file.name
}*/
println("-------------------------------------------")
/*def process = "ls -l".execute()
process.in.eachLine { line ->
    println line
}*/
/*
def process = "cmd /c dir".execute()
println "${process.text}"*/
proc1 = 'ls'.execute()
proc2 = 'tr -d o'.execute()
proc3 = 'tr -d e'.execute()
proc4 = 'tr -d i'.execute()
proc1 | proc2 | proc3 | proc4
proc4.waitFor()
if (proc4.exitValue()) {
    println proc4.err.text
} else {
    println proc4.text
}