data class Food(val food: String, val cuisine: String, val rating: Int) : Comparable<Food> {
    override fun compareTo(other: Food): Int {
        if (this.rating == other.rating) return this.food.compareTo(other.food)
        return other.rating.compareTo(this.rating)
    }
}

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val foodRatingMap = HashMap<String, Int>()
    private val foodCuisineMap = HashMap<String, String>()
    private val cuisineFoodMap = HashMap<String, PriorityQueue<Food>>()

    init {
        for (i in foods.indices) {
            foodRatingMap[foods[i]] = ratings[i]
            foodCuisineMap[foods[i]] = cuisines[i]

            cuisineFoodMap
                .computeIfAbsent(cuisines[i]) { PriorityQueue<Food>() }
                .add(Food(foods[i], cuisines[i], ratings[i]))
        }
    }

    fun changeRating(food: String, newRating: Int) {
        foodRatingMap[food] = newRating
        val cuisine = foodCuisineMap[food]!!

        
        cuisineFoodMap[cuisine]!!
            .add(Food(food, cuisine, newRating))
    }

    fun highestRated(cuisine: String): String {
        var highestRated = cuisineFoodMap[cuisine]!!.peek()

        while(foodRatingMap[highestRated.food] != highestRated.rating) {
            cuisineFoodMap[cuisine]!!.poll()
            highestRated = cuisineFoodMap[cuisine]!!.peek()
        }
        
        return highestRated.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * var obj = FoodRatings(foods, cuisines, ratings)
 * obj.changeRating(food,newRating)
 * var param_2 = obj.highestRated(cuisine)
 */

