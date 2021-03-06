RestModelGenerator
==================

This tool is intended for developers of REST applications. It will generate simple objects that can represend the json or xml your rest interface accepts. This tool is not limited to rest, it is intended to generate data type objects for any purpose.

A simple syntax is used to define your objects. Once you have created these model definition files you can generate your code as required.

Currently supported languages are:

+ Java
+ Ruby

Get started fast! Replace the example model files in the `models` directory with some of your own then run `generate.bat` on windows or `generate.sh` on linux and osx. 

Creating model files
--------------------

File names must be in the following format `"<class name>.model"`. Example: `myClass.model`

All line endings are denoted by a semicolumn and all white spaces in files are ignored.

The first entry in the file should be the output directory or package for the file, folders delimeted by forward slash. 

Example:
```
test/output/dir;
```

After the folder output line the class body declration can begin. The class body is encapsulated by curly brackets. You declear each variable and variable type of the class within the body. Varaible names must be in lower camel case.

Variable name off member variables are declared first, followed by a column then the type and then a semicolumn to denote the end of line `"<variable name>:<type>;"`.

Example:
```
testVar:String;
```

A List is declared the same as normal variables (as if the list was the type) but the type of objects in the list is denoted following the type. `"<variable name>:List:<type>;"`

Example:
```
testList:List:String;
```

The following types plus your defined objects are currently supported:
```
<var name>:String;
<var name>:Integer;
<var name>:Float;
<var name>:Boolean;
<var name>:Date;
<var name>:List:<list type>;
```

Model file example
----------------------
Filename: `test.model`
```html
com/model/test;
{
    id:Integer;
    name:String;

}
```

This would generate the following

Java:
```java
package com.model.test;

public class Test {
   private Integer id;
   private String name;
   
   public Integer getId(){
      return this.id;
   }
   
   public void setId(String id){
      this.id = id;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      this.name = name;
   }
}
```

Ruby:
```ruby
 module Com 
 module Model 
 module Test 

    class Test
       attr_accessor :id, :name
    end
 end
 end
 end
```
Replacing Templates
--------------------
If you look at the source code in `CodeGeneration/src/main/resources/templates` you will find the templates used to generate the code. You can copy these files change them as you see fit then place them in the directory you are running the project in the subfolder templates.

Feature Development
---------------------
There are allot more features to some to RestModelGenerator so if there is something think needs adding or want to help out let me know beachy.greg@gmail.com!

Features still to be developed
+ C# language generation.
+ Add support for Map type.
+ Add adders to pojo's for lists.
+ Add annotations or something to mode file syntax for more flexability in language generation.
+ Allow model files to extend other mode files (note not for class extension). 
