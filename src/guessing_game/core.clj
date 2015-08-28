(ns guessing-game.core
  (:gen-class))

(defn rand-num
  "Gets a random number between 1 and 100"
  []
  (+ (rand-int 100) 1))

(defn check-input
  [secret input]
  (cond
    (< input secret) "Too small!"
    (> input secret) "Too big!"
    :else "You win!"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Guess the number!")
  (def secret-num (rand-num))
  (loop []
    (println "Please input your guess.")
    (def input (read-string (read-line)))
    (println (str "You guessed: " input))
    (def check (check-input secret-num input))
    (println check)
    (if (not= "You win!" check)
      (recur))))
