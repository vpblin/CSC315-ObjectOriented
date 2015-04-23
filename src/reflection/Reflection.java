package reflection;

import java.awt.Point;
import java.lang.reflect.*;

public class Reflection {

	static void showMethods(Object o) {

		// -- get the actual class
		Class c = o.getClass();

		// -- get the friendly name
		String classname = c.getName();
		System.out.println("Class type: " + classname);

		String modifiers = "";
		int mods = c.getModifiers();
		if (Modifier.isPublic(mods))
			modifiers += "public ";
		if (Modifier.isAbstract(mods))
			modifiers += "abstract ";
		if (Modifier.isFinal(mods))
			modifiers += "final ";
		System.out.println("Modifiers: " + modifiers);
		
		// -- get the super class
		Class<?> superclass = c.getSuperclass();
		System.out.println("Super class type: " + superclass);
	
		// -- get the fields (member variables)
		System.out.println("Fields: ");
		Field[] publicFields = c.getFields();
		String fieldTypes = "";
		for (Field f : publicFields) {
			Class<?> ftype = f.getType();
			fieldTypes += (ftype.isArray()) ? (ftype.getComponentType() + "[] " + f.getName() + ",") : (ftype.getName() + " " + f.getName() + ",");
		}
		if (publicFields.length > 0) {
			System.out.println(fieldTypes.substring(0, fieldTypes.length() - 1));
		}	
	
		// -- get the available constructors
		System.out.println("Methods: ");
		Constructor<?>[] theConstructors = c.getConstructors();
		for (Constructor<?> constructor : theConstructors) {
			// -- get the parameters
			String parameters = "";
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (Class<?> ptype : parameterTypes) {
				parameters += (ptype.isArray()) ? (ptype.getComponentType() + "[],") : (ptype.getName() + ",");
			}
			if (parameterTypes.length > 0) {
				System.out.println(classname + "(" + parameters.substring(0, parameters.length() - 1) + ")");
			} 
			else {
				System.out.println(classname + "( )");
			}
		}
		
		// -- get the available methods
		System.out.println("Methods: ");
		Method[] theMethods = c.getMethods();
		for (Method m : theMethods) {
			// -- get the method name
			String methodName = m.getName();

			// -- get the return type
			String returnType;
			Class<?> rtype = m.getReturnType();
			returnType = (rtype.isArray()) ? (rtype.getComponentType() + "[]") : (rtype.getName());

			// -- get the parameters
			String parameters = "";
			Class<?>[] parameterTypes = m.getParameterTypes();
			for (Class<?> ptype : parameterTypes) {
				parameters += (ptype.isArray()) ? (ptype.getComponentType() + "[],") : (ptype.getName() + ",");
			}
			if (parameterTypes.length > 0) {
				System.out.println(methodName + " " + returnType + "(" + parameters.substring(0, parameters.length() - 1) + ")");
			}
			else {
				System.out.println(methodName + " " + returnType + "( )");
			}
			
		}
	}

	public static void main(String[] args) {
		Point p = new Point(1, 2);
		Reflection.showMethods(p);
		System.out.println("==============");

		String s = "hello";
		Reflection.showMethods(s);
		System.out.println("==============");
		
		
		
		// -- get the class of the variable s (runtime operation)
		Class<?> c = s.getClass();
		try {
			// -- instantiate the class found above
			Object o = c.newInstance();
			
			// -- determine the actual instanceof the instantiated object
			if (o instanceof String) {
				// -- cast the object to something useful
				String str = (String)o;
				str = "hello, world!";
				System.out.println(str);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
