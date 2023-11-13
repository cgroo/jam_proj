class Pet:
    def __init__(self, name, type):
        self.pet_name = name
        self.pet_age = 0
        self.clean_level = 50
        self.hunger_level = 50
        self.thirst_level = 50
        self.happiness_level = 50

    def get_name(self):
        return self.pet_name

    def get_age(self):
        return self.pet_age

    def get_clean_level(self):
        return self.clean_level

    def get_hunger_level(self):
        return self.hunger_level

    def get_thirst_level(self):
        return self.thirst_level

    def get_happiness_level(self):
        return self.happiness_level

    def set_name(self, name):
        self.pet_name = name

    def increment_age(self):
        self.pet_age += 1

    def add_clean(self, amount):
        self.clean_level += amount
        if self.clean_level > 100:
            self.clean_level = 100

    def remove_clean(self, amount):
        self.clean_level -= amount
        if self.clean_level < 0:
            self.clean_level = 0

    def add_hunger(self, amount):
        self.hunger_level += amount
        if self.hunger_level > 100:
            self.hunger_level = 100

    def remove_hunger(self, amount):
        self.hunger_level -= amount
        if self.hunger_level < 0:
            self.hunger_level = 0

    def add_thirst(self, amount):
        self.thirst_level += amount
        if self.thirst_level > 100:
            self.thirst_level = 100

    def remove_thirst(self, amount):
        self.thirst_level -= amount
        if self.thirst_level < 0:
            self.thirst_level = 0

    def add_happy(self, amount):
        self.happiness_level += amount
        if self.happiness_level > 100:
            self.happiness_level = 100

    def remove_happy(self, amount):
        self.happiness_level -= amount
        if self.happiness_level < 0:
            self.happiness_level = 0


class Dog(Pet):
    def __init__(self):
        super().__init__()

    def show_happiness(self):
        if self.happiness_level >= 90:
            print("Woof! :) i'm happy")
        elif self.happiness_level >= 50:
            print("Woof :l i'm alright")
        else:
            print("woof :( give me attention")

    def show_cleanliness(self):
        if self.clean_level >= 90:
            print("Woof! :) i smell great")
        elif self.clean_level >= 50:
            print("Woof :l i'm a lil stinky")
        else:
            print("woof :( please clean me")

    def show_fullness(self):
        if self.hunger_level >= 90:
            print("Woof! :) i'm so full")
        elif self.hunger_level >= 50:
            print("Woof :l stomach's grumbling a bit")
        else:
            print("woof :( please feed me")

    def show_quench(self):
        if self.thirst_level >= 90:
            print("Woof! :) i'm not thirsty")
        elif self.hunger_level >= 50:
            print("Woof :l i could go for some water")
        else:
            print("woof :( i'm dying of thirst")

    def trick_spin(self):
        if self.get_happiness_level() > 50:
            print(self.get_name() + " spins around in happiness")

    def trick_paw(self):
        if self.get_happiness_level() > 50:
            print(self.get_name() + " extends their paw in happiness")

    def trick_speak(self):
        if self.get_happiness_level() > 50:
            print(self.get_name() + " barks in happiness")


class Cat(Pet):
    def show_happiness(self):
        if self.happiness_level >= 90:
            print("Meow! :) i'm happy")
        elif self.happiness_level >= 50:
            print("Meow :l i'm alright")
        else:
            print("meow :( give me attention")

    def show_cleanliness(self):
        if self.clean_level >= 90:
            print("Meow! :) i smell great")
        elif self.clean_level >= 50:
            print("Meow :l i'm a lil stinky")
        else:
            print("meow :( please clean me")

    def show_fullness(self):
        if self.hunger_level >= 90:
            print("Meow! :) i'm so full")
        elif self.hunger_level >= 50:
            print("Meow :l stomach's grumbling a bit")
        else:
            print("meow :( please feed me")

    def show_quench(self):
        if self.thirst_level >= 90:
            print("Meow! :) i'm not thirsty")
        elif self.hunger_level >= 50:
            print("Meow :l i could go for some water")
        else:
            print("meow :( i'm dying of thirst")


class Rat(Pet):
    def __init__(self):
        super().__init__()

    def show_happiness(self):
        if self.happiness_level >= 90:
            print("Squeak! :) i'm happy")
        elif self.happiness_level >= 50:
            print("Squeak :l i'm alright")
        else:
            print("squeak :( give me attention")

    def show_cleanliness(self):
        if self.clean_level >= 90:
            print("Squeak! :) i smell great")
        elif self.clean_level >= 50:
            print("Squeak :l i'm a lil stinky")
        else:
            print("squeak :( please clean me")

    def show_fullness(self):
        if self.hunger_level >= 90:
            print("Squeak! :) i'm so full")
        elif self.hunger_level >= 50:
            print("Squeak :l stomach's grumbling a bit")
        else:
            print("squeak :( please feed me")

    def show_quench(self):
        if self.thirst_level >= 90:
            print("Squeak! :) i'm not thirsty")
        elif self.hunger_level >= 50:
            print("Squeak :l i could go for some water")
        else:
            print("squeak :( i'm dying of thirst")


class User:
    def __init__(self, name):
        self.user_name = name


# Example usage:
def main():
    user_input_name = input("What is your name? ")
    user_input_pet_type = input("What pet do you want? (Type Dog, Cat or Rat) ")
    user = User(user_input_name)
    pet = Pet(user_input_pet_type)
    # Other logic...


if __name__ == "__main__":
    main()