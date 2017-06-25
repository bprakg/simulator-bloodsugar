package com.healthiq.simulator.bloodsugar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.healthiq.simulator.bloodsugar.bean.Exercise;
import com.healthiq.simulator.bloodsugar.bean.Food;
import com.healthiq.simulator.bloodsugar.repository.ExerciseRepository;
import com.healthiq.simulator.bloodsugar.repository.FoodRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private FoodRepository fr;
	@Autowired
	private ExerciseRepository er;

	@Override
	public void run(String... strings) throws Exception {
		loadFoodGI();
		loadExerciseEI();
	}

	private void loadFoodGI() {
		this.fr.save(new Food("Banana cake, made with sugar", 47));
		this.fr.save(new Food("Banana cake, made without sugar", 55));
		this.fr.save(new Food("Sponge cake, plain", 46));
		this.fr.save(new Food("Vanilla cake made from packet mix with vanilla frosting (Betty Crocker)", 42));
		this.fr.save(new Food("Apple, made with sugar", 44));
		this.fr.save(new Food("Apple, made without sugar", 48));
		this.fr.save(new Food("Waffles, Aunt Jemima (Quaker Oats)", 76));
		this.fr.save(new Food("Bagel, white, frozen", 72));
		this.fr.save(new Food("Baguette, white, plain", 95));
		this.fr.save(new Food("Coarse barley bread, 75-80% kernels, average", 34));
		this.fr.save(new Food("Hamburger bun", 61));
		this.fr.save(new Food("Kaiser roll", 73));
		this.fr.save(new Food("Pumpernickel bread", 56));
		this.fr.save(new Food("50% cracked wheat kernel bread", 58));
		this.fr.save(new Food("White wheat flour bread", 71));
		this.fr.save(new Food("Wonder™ bread, average", 73));
		this.fr.save(new Food("Whole wheat bread, average", 71));
		this.fr.save(new Food("100% Whole Grain™ bread (Natural Ovens)", 51));
		this.fr.save(new Food("Pita bread, white", 68));
		this.fr.save(new Food("Corn tortilla", 52));
		this.fr.save(new Food("Wheat tortilla", 30));
		this.fr.save(new Food("Coca Cola®, average", 63));
		this.fr.save(new Food("Fanta®, orange soft drink", 68));
		this.fr.save(new Food("Lucozade®, original (sparkling glucose drink)", 95));
		this.fr.save(new Food("Apple juice, unsweetened, average", 44));
		this.fr.save(new Food("Cranberry juice cocktail (Ocean Spray®)", 68));
		this.fr.save(new Food("Gatorade", 78));
		this.fr.save(new Food("Orange juice, unsweetened", 50));
		this.fr.save(new Food("Tomato juice, canned", 38));
		this.fr.save(new Food("All-Bran™, average", 55));
		this.fr.save(new Food("Coco Pops™, average", 77));
		this.fr.save(new Food("Cornflakes™, average", 93));
		this.fr.save(new Food("Cream of Wheat™ (Nabisco)", 66));
		this.fr.save(new Food("Cream of Wheat™, Instant (Nabisco)", 74));
		this.fr.save(new Food("Grapenuts™, average", 75));
		this.fr.save(new Food("Muesli, average", 66));
		this.fr.save(new Food("Oatmeal, average", 55));
		this.fr.save(new Food("Instant oatmeal, average", 83));
		this.fr.save(new Food("Puffed wheat, average", 80));
		this.fr.save(new Food("Raisin Bran™ (Kellogg's)", 61));
		this.fr.save(new Food("Special K™ (Kellogg's)", 69));
		this.fr.save(new Food("Pearled barley, average", 28));
		this.fr.save(new Food("Sweet corn on the cob, average", 60));
		this.fr.save(new Food("Couscous, average", 65));
		this.fr.save(new Food("Quinoa", 53));
		this.fr.save(new Food("White rice, average", 89));
		this.fr.save(new Food("Quick cooking white basmati", 67));
		this.fr.save(new Food("Brown rice, average", 50));
		this.fr.save(new Food("Converted, white rice (Uncle Ben's®)", 38));
		this.fr.save(new Food("Whole wheat kernels, average", 30));
		this.fr.save(new Food("Bulgur, average", 48));
		this.fr.save(new Food("Graham crackers", 74));
		this.fr.save(new Food("Vanilla wafers", 77));
		this.fr.save(new Food("Shortbread", 64));
		this.fr.save(new Food("Rice cakes, average", 82));
		this.fr.save(new Food("Rye crisps, average", 64));
		this.fr.save(new Food("Soda crackers", 74));
		this.fr.save(new Food("Ice cream, regular", 57));
		this.fr.save(new Food("Ice cream, premium", 38));
		this.fr.save(new Food("Milk, full fat", 41));
		this.fr.save(new Food("Milk, skim", 32));
		this.fr.save(new Food("Reduced-fat yogurt with fruit, average", 33));
		this.fr.save(new Food("Apple, average", 39));
		this.fr.save(new Food("Banana, ripe", 62));
		this.fr.save(new Food("Dates, dried", 42));
		this.fr.save(new Food("Grapefruit", 25));
		this.fr.save(new Food("Grapes, average", 59));
		this.fr.save(new Food("Orange, average", 40));
		this.fr.save(new Food("Peach, average", 42));
		this.fr.save(new Food("Peach, canned in light syrup", 40));
		this.fr.save(new Food("Pear, average", 38));
		this.fr.save(new Food("Pear, canned in pear juice", 43));
		this.fr.save(new Food("Prunes, pitted", 29));
		this.fr.save(new Food("Raisins", 64));
		this.fr.save(new Food("Watermelon", 72));
		this.fr.save(new Food("Baked beans, average", 40));
		this.fr.save(new Food("Blackeye peas, average", 33));
		this.fr.save(new Food("Black beans", 30));
		this.fr.save(new Food("Chickpeas, average", 10));
		this.fr.save(new Food("Chickpeas, canned in brine", 38));
		this.fr.save(new Food("Navy beans, average", 31));
		this.fr.save(new Food("Kidney beans, average", 29));
		this.fr.save(new Food("Lentils, average", 29));
		this.fr.save(new Food("Soy beans, average", 15));
		this.fr.save(new Food("Cashews, salted", 27));
		this.fr.save(new Food("Peanuts, average", 7));
		this.fr.save(new Food("Fettucini, average", 32));
		this.fr.save(new Food("Macaroni, average", 47));
		this.fr.save(new Food("Macaroni and Cheese (Kraft)", 64));
		this.fr.save(new Food("Spaghetti, white, boiled, average", 46));
		this.fr.save(new Food("Spaghetti, white, boiled 20 min, average", 58));
		this.fr.save(new Food("Spaghetti, wholemeal, boiled, average", 42));
		this.fr.save(new Food("Corn chips, plain, salted, average", 42));
		this.fr.save(new Food("Fruit Roll-Ups®", 99));
		this.fr.save(new Food("M & M's®, peanut", 33));
		this.fr.save(new Food("Microwave popcorn, plain, average", 55));
		this.fr.save(new Food("Potato chips, average", 51));
		this.fr.save(new Food("Pretzels, oven-baked", 83));
		this.fr.save(new Food("Snickers Bar®", 51));
		this.fr.save(new Food("Carrots, average", 35));
		this.fr.save(new Food("Parsnips", 52));
		this.fr.save(new Food("Baked russet potato, average", 111));
		this.fr.save(new Food("Boiled white potato, average", 82));
		this.fr.save(new Food("Instant mashed potato, average", 87));
		this.fr.save(new Food("Sweet potato, average", 70));
		this.fr.save(new Food("Yam, average", 54));
		this.fr.save(new Food("Green peas, average", 51));
		this.fr.save(new Food("Hummus (chickpea salad dip)", 6));
		this.fr.save(new Food("Chicken nuggets, frozen, reheated in microwave oven 5 min", 46));
		this.fr.save(new Food("Pizza, plain baked dough, served with parmesan cheese and tomato sauce", 80));
		this.fr.save(new Food("Pizza, Super Supreme (Pizza Hut)", 36));
		this.fr.save(new Food("Honey, average", 61));
	}

	private void loadExerciseEI() {
		this.er.save(new Exercise("Crunches", 20));
		this.er.save(new Exercise("Walking", 15));
		this.er.save(new Exercise("Running", 40));
		this.er.save(new Exercise("Sprinting", 60));
		this.er.save(new Exercise("Squats", 60));
		this.er.save(new Exercise("Bench press", 45));
	}

}