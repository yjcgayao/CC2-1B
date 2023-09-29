# Divider Declaration
divider_length = 35
divider = "=" * divider_length

# Task 1: Convert pounds to kilograms
pounds = 250
kilograms = pounds * 0.45359237
print(f"Weight in Pounds (lbs): {pounds}")
print(f"Weight converted to Kilograms (kg): {kilograms:.2f}")

print(divider)

# Task 2: Convert miles to kilometers
miles = 15
kilometers = miles * 1.60934
print(f"Length in Miles (mi): {miles}")
print(f"Length in Kilometers (km): {kilometers:.2f}")

print(divider)

# Task 3: Convert Fahrenheit to Celsius
fahrenheit = 8500
celsius = (fahrenheit - 32) * 5/9
print(f"Temperature in Fahrenheit (°F): {fahrenheit}")
print(f"Temperature in Celsius (°C): {celsius:.2f}")

print(divider)

# Task 4: Calculate the average age of students
ages = [24, 20, 22, 22, 19, 23, 25, 26, 20, 22]
average_age = sum(ages) / len(ages)
for i, age in enumerate(ages, 1):
    print(f"Age of Student {i}: {age}")
print(f"The average age of the students is: {average_age:.1f}")

print(divider)

# Task 5: Output a fantasy story
protagonists = "Chef Ella and her loyal kitchen companions"
culinary_weapon = "<Magic Whisk Wand>"
culinary_armor = "<Apron of Harmony>"
culinary_skill = "<Ella's Heartwarming Recipes>"
ultimate_culinary_skill = "<Dishes of Unity>"

story = f"In a land filled with the aroma of delicious dishes, the benevolent ruler, King Jasper, decided to bring the kingdom together through the joy of cooking. He organized a grand culinary event in the serene Harmony Valley. Our cherished heroes, {protagonists}, were renowned for their culinary talents and their ability to unite people through food. They wholeheartedly embraced the challenge, adorning themselves with the {culinary_armor} and wielding the {culinary_weapon}, a wand known for its magical stirring abilities. As the competition unfolded, King Jasper showcased his own culinary expertise with an array of unique ingredients, but our heroes, with their {culinary_skill}, crafted dishes that not only delighted the palate but also warmed the hearts of all who tasted them. Ella's cooking brought harmony to the kingdom like never before. However, King Jasper had a heartwarming surprise of his own. He gathered ingredients symbolizing unity and used them to create the {ultimate_culinary_skill}, a set of dishes that magically brought everyone together and fostered a deep sense of togetherness."

print(story)
