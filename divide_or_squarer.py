def divide_or_square(number):
   if number % 5 == 0:
     return number ** 0.5
   elif number % 5 != 0:
     return number % 5
   if number  + 5 == 0:
     return number ** 0.5




num = divide_or_square(77)	
print (num)