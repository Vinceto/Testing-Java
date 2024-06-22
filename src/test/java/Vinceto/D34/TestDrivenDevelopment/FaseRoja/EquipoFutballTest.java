package Vinceto.D34.TestDrivenDevelopment.FaseRoja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipoFutballTest {
    @Test
    public void constructorDebeSetearJuegosGanados() {
        EquipoFutball team = new EquipoFutball(3);
        assertEquals(3, team.getJuegosGanados());
    }
}

/*

C:\Users\Hely\.jdks\corretto-17.0.11\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.1\lib\idea_rt.jar=51321:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\Hely\.m2\repository\org\junit\platform\junit-platform-launcher\1.11.0-M2\junit-platform-launcher-1.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\junit\vintage\junit-vintage-engine\5.11.0-M2\junit-vintage-engine-5.11.0-M2.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.1\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.1\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.1\plugins\junit\lib\junit-rt.jar;C:\Users\Hely\Documents\RBMN repositories\Testing-Java\target\test-classes;C:\Users\Hely\Documents\RBMN repositories\Testing-Java\target\classes;C:\Users\Hely\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;C:\Users\Hely\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\Hely\.m2\repository\org\mockito\mockito-core\5.11.0\mockito-core-5.11.0.jar;C:\Users\Hely\.m2\repository\net\bytebuddy\byte-buddy\1.14.12\byte-buddy-1.14.12.jar;C:\Users\Hely\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.12\byte-buddy-agent-1.14.12.jar;C:\Users\Hely\.m2\repository\org\objenesis\objenesis\3.3\objenesis-3.3.jar;C:\Users\Hely\.m2\repository\org\junit\jupiter\junit-jupiter\5.11.0-M2\junit-jupiter-5.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.11.0-M2\junit-jupiter-api-5.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\opentest4j\opentest4j\1.3.0\opentest4j-1.3.0.jar;C:\Users\Hely\.m2\repository\org\junit\platform\junit-platform-commons\1.11.0-M2\junit-platform-commons-1.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;C:\Users\Hely\.m2\repository\org\junit\jupiter\junit-jupiter-params\5.11.0-M2\junit-jupiter-params-5.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.11.0-M2\junit-jupiter-engine-5.11.0-M2.jar;C:\Users\Hely\.m2\repository\org\junit\platform\junit-platform-engine\1.11.0-M2\junit-platform-engine-1.11.0-M2.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 Vinceto.D34.TestDrivenDevelopment.FaseRoja.EquipoFutballTest

org.opentest4j.AssertionFailedError:
Expected :3
Actual   :0
<Click to see difference>


	at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
	at org.junit.jupiter.api.AssertionFailureBuilder.buildAndThrow(AssertionFailureBuilder.java:132)
	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:197)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:150)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:145)
	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:531)
	at Vinceto.D34.TestDrivenDevelopment.FaseRoja.EquipoFutballTest.constructorDebeSetearJuegosGanados(EquipoFutballTest.java:9)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)

 */