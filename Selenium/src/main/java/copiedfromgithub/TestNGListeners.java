package copiedfromgithub;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNGListeners implements IAnnotationTransformer , IRetryAnalyzer{
int iMaxRetry = 1;
@Override
public void transform(ITestAnnotation annotation, Class testClass,
Constructor testConstructor, Method testMethod) {
annotation.setRetryAnalyzer(this.getClass());
annotation.setInvocationCount(1);
if(!testMethod.getName().equalsIgnoreCase("createLead")) {			
annotation.setEnabled(false);
}
}
@Override
public boolean retry(ITestResult result) {
if(!result.isSuccess() && iMaxRetry < 2) {
iMaxRetry++;
return true;			
} else {
return false;
}

}

}
