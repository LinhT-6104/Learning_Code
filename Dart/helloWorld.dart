import 'dart:math';

void _string_() {
  print('STRING');
  
  // multiline
  String d_multiLine = '''  Nice to
      Meet you    !''';
  print(d_multiLine);

  String d_1 = 'Hello Dev Comentry';
  String d_2 = "I'm Duc Linh";
  print("'Hello Dev Comentry'[0]: ${d_1[0]}");  // string index
  print('substring(0, 4): ${d_1.substring(0, 5)}'); // subtring
  print('length of string: ${d_1.length}');  //length of string
  print('multiString: ${d_2 * 4}'); // multiString

  // trim
  String d_trim = '  trim_string    ';
  print('trim: $d_trim -> ${d_trim.trim()}');


  // split
  List d_list_string = d_2.split(' ');
  print('split string: $d_list_string');

  // string connection
  String d_3 = d_1 + " " + d_2 + " " + d_multiLine;
  print("sum string 1: $d_3");
  String d_4 = "Hello" 'world!';
  print("sum string 2: $d_4");
  
  // parse int
  String d_string = '40';
  int d_int = int.parse(d_string); 
  print('parse int: ${d_int + 5}'); 
}

void _number_() {
  print("\nNumber");
  num number1 = 20;
  number1 = -20;
  number1 = -14.49;
  number1 = 14.49;

  num number2 = 12.49;

  // to double
  print('to double: ${number1.toDouble()}');
  
  // to int
  print('to int: ${number2.toInt()}');

  // round
  print('round 14.49: ${(number1.round())}');
  print('round 14.5: ${((number1 + 0.01).round())}');
  print('round 14.59: ${((number1 + 0.1).round())}');
  
  // Random
  int random_int = Random().nextInt(5);
  double random_double = Random().nextDouble();
  bool random_boolean = Random().nextBool();
  print('random_int: ${random_int}');
  print('random_double: ${random_double}');
  print('random_boolean: ${random_boolean}');

  
  int e_int = 5;
  print('Chia lay nguyen: ${e_int ~/ 2}');
  print('Chia lay du: ${e_int % 2}');

  double e_double;
}

void _boolean_() {
  print("\Boolean");
  bool isB;
  bool hasB;
}

void _list_() {
  print("\nList");
  List<String> cars = []; // -> []
  cars.add('Lexus');  // [Lexus]
  cars.addAll(['Toyota', 'Honda', 'Hyundai']);  // [Lexus, Toyota, Honda, Hyundai]
  cars.insert(1, 'Vinfast');  // [Lexus, Vinfast, Toyota, Honda, Hyundai]
  cars.insertAll(1, ['Ducati', 'Bugatti']);  // [Lexus, Ducati, Bugatti, Vinfast, Toyota, Honda, Hyundai]
  cars.removeAt(2); // [Lexus, Ducati, Vinfast, Toyota, Honda, Hyundai]
  cars.removeLast(); // [Lexus, Ducati, Vinfast, Toyota, Honda]
  cars.removeRange(0, 2); // [Vinfast, Toyota, Honda]
  cars.clear(); // []

  cars = ['car1', 'car2', 'car3', 'car4'];  // [car1, car2, car3, car4]
  cars.replaceRange(0, 4, ['Lexus', 'Ducati', 'Bugatti', 'Vinfast']);
  
  // for each\
  print('For each:');
  cars.forEach((car) {
    print(car);
  });

  print('\nMap:');
  var car = cars.map((e) => e + "aa");
  print(car);

  print('So luong phan tu: ${cars.length}');
  print(cars);
}

main(List<String> args) {
  var a_var = 1;
  const a_const = "const";
  final a_final = "final";

  // String
  _string_();

  // Number
  _number_();

  // Boolean
  // _boolean_();

  // List
  _list_();
}