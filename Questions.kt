package cat.itb.m78.exercices.practicaTrivial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.trivial
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

data class MyQuestion(
    val unit : String,
    val askFor : String,
    val answer1 : String,
    val answer2 : String,
    val answer3 : String,
    val answer4 : String,
    val clueItsYourAnswerCorrect : String,
    val correctOne : Int
)
val questions = listOf(
    MyQuestion(
        askFor = "What is the capital of France?",
        answer1 = "Madrird",
        answer2 = "Paris",
        answer3 = "Berlin",
        answer4 = "Rome",
        clueItsYourAnswerCorrect = "It's known as the City of Love 💕",
        correctOne = 2
    ),
    MyQuestion(
        askFor = "How many legs does a spider have?",
        answer1 = "6",
        answer2 = "10",
        answer3 = "12",
        answer4 = "8",
        clueItsYourAnswerCorrect = "It's more than an insect, but less than a centipede! 🕸️",
        correctOne = 4
    ),
    MyQuestion(
        askFor = "Which planet is known as the Red Planet?",
        answer1 = "Venus",
        answer2 = "Jupiter",
        answer3 = "Mars",
        answer4 = "Saturn",
        clueItsYourAnswerCorrect = "Named after the Roman god of war! ⚔️",
        correctOne = 3
    ),
    MyQuestion(
        askFor = "Whait is 5 + 3?",
        answer1 = "6",
        answer2 = "8",
        answer3 = "7",
        answer4 = "9",
        clueItsYourAnswerCorrect = "Hint: Think of a magic 8-ball! 🎱",
        correctOne = 2
    ),
    MyQuestion(
        askFor =  "Which animal is the king of the jungle?",
        answer1 = "Elephant",
        answer2 = "Tiger",
        answer3 = "Lion",
        answer4 = "Bear",
        clueItsYourAnswerCorrect = "It has a loud roar! 🗣️",
        correctOne = 3
    ),
    MyQuestion(
        askFor =  "What is the largest ocean on Earth? ",
        answer1 = "Pacific Ocean",
        answer2 = "Atlantic Ocean",
        answer3 = "Indian Ocean",
        answer4 = "Arctic Ocean",
        clueItsYourAnswerCorrect = " It covers more than 30% of the Earth's surface!",
        correctOne = 1
    ),
    MyQuestion(
        askFor =  "Who painted the Mona Lisa? 🎨",
        answer1 = "Vincent van Gogh",
        answer2 = "Pablo Picasso",
        answer3 = "Leonardo da Vinci",
        answer4 = "Michelangelo",
        clueItsYourAnswerCorrect = "He was also an inventor and scientist! 🏛️",
        correctOne = 3
    ),
    MyQuestion(
        askFor =  "Which element has the chemical symbol 'O'?",
        answer1 = "Carbon",
        answer2 = "Gold",
        answer3 = "Hydrogen",
        answer4 = "Oxygen",
        clueItsYourAnswerCorrect = "We need it to breathe! 🌬️",
        correctOne = 4
    ),
    MyQuestion(
        askFor = "In which year did the Titanic sink?",
        answer1 = "1905",
        answer2 = "1912",
        answer3 = "1923",
        answer4 = "1931",
        clueItsYourAnswerCorrect = "It hit an iceberg on its maiden voyage! ❄️",
        correctOne = 2
    ),
    MyQuestion(
        askFor =  "Which country has the most pyramids in the world?",
        answer1 = "Egypt",
        answer2 = "Mexico",
        answer3 = "Sudan",
        answer4 = "Peru",
        clueItsYourAnswerCorrect = "It has more than 200 pyramids, even more than Egypt! 🏺",
        correctOne = 3
    ),
    MyQuestion(
        askFor =  "Which is the only metal that is liquid at room temperature?",
        answer1 = "Sodium",
        answer2 = "Lead",
        answer3 = "Gallium",
        answer4 = "Mercury",
        clueItsYourAnswerCorrect = "It was historically used in thermometers! 🌡️",
        correctOne = 4
    ),
    MyQuestion(
        askFor =  "What is the name of the deepest point in the ocean?",
        answer1 = "Mariana Trench",
        answer2 = "Tonga Trench",
        answer3 = "Philippine Trench",
        answer4 = "Java Trench",
        clueItsYourAnswerCorrect = "It is located in the Pacific Ocean and reaches about 11,000 meters deep! ⬇️",
        correctOne = 1
    ),
    MyQuestion(
        askFor =  "Who was the first person to reach the South Pole?",
        answer1 = "Robert Falcon Scott",
        answer2 = "Ernest Shackleton",
        answer3 = "Edmund Hillary",
        answer4 = "Roald Amundsen",
        clueItsYourAnswerCorrect = "He was a Norwegian explorer who arrived in 1911!",
        correctOne = 4
    ),
    MyQuestion(
        askFor =  "Which mathematical constant is known as Euler’s number?",
        answer1 = "π (Pi)",
        answer2 = "φ (Phi)",
        answer3 = "e",
        answer4 = " i (imaginary unit)",
        clueItsYourAnswerCorrect = "It is approximately equal to 2.718 and is used in logarithms and exponential growth! 📈",
        correctOne = 3
    ),
    MyQuestion(
        askFor =  "What is the rarest blood type in the world?",
        answer1 = "O-",
        answer2 = "AB-",
        answer3 = "B-",
        answer4 = "Rh-null",
        clueItsYourAnswerCorrect = "It’s called the “Golden Blood” because fewer than 50 people in the world have it! 🏆",
        correctOne = 4
    )
)

@Composable
fun QuestionUsingList(
    navigateToResultScreen:(Int) -> Unit
){
    val questionAnswered = remember{ mutableStateOf(false) }
    val answeredWell = remember{ mutableStateOf(false) }
    val question = remember{ mutableStateOf(0) }
    val unit = questions[question.value].unit
    val askFor =  questions[question.value].askFor
    val answer1 = questions[question.value].answer1
    val answer2 = questions[question.value].answer2
    val answer3 = questions[question.value].answer3
    val answer4 = questions[question.value].answer4
    val clueItsYourAnswerCorrect = questions[question.value].clueItsYourAnswerCorrect
    val correctOne = questions[question.value].correctOne
    val roundsCounter = remember{ mutableStateOf(1) }
    val points = remember { mutableStateOf(0) }

    //Only for questions 7 and 14, which are a gambling question
    val correctColor = remember{ mutableStateOf( Random.nextInt(1, 5) ) }

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        if (!questionAnswered.value){
            Text(unit, modifier = Modifier.padding(20.dp))
            Spacer(modifier = Modifier.size(25.dp))

            Image(
                painter = painterResource(Res.drawable.trivial),
                modifier = Modifier.size(150.dp).padding(15.dp),
                contentDescription = null
            )

            Text(askFor)
            Spacer(modifier = Modifier.size(10.dp))
            Row {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {
                            if (!questionAnswered.value && correctOne != 0) {
                                if (correctOne == 1) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            } else if (!questionAnswered.value){
                                if (correctColor.value == 1) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            }
                        },
                        modifier = Modifier.background(Color.Red).size(200.dp, 75.dp)
                            .padding(10.dp)
                    ) {
                        Text(answer1, textAlign = TextAlign.Center)
                    }
                    Button(
                        onClick = {
                            if (!questionAnswered.value && correctOne != 0) {
                                if (correctOne == 3) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            } else if (!questionAnswered.value){
                                if (correctColor.value == 3) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            }
                        },
                        modifier = Modifier.background(Color.Yellow).size(200.dp, 75.dp)
                            .padding(10.dp)
                    ) {
                        Text(answer3, textAlign = TextAlign.Center)
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {
                            if (!questionAnswered.value && correctOne != 0) {
                                if (correctOne == 2) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            } else if (!questionAnswered.value){
                                if (correctColor.value == 2) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            }
                        },
                        modifier = Modifier.background(Color.Blue).size(200.dp, 75.dp)
                            .padding(10.dp)
                    ) {
                        Text(answer2, textAlign = TextAlign.Center)
                    }
                    Button(
                        onClick = {
                            if (!questionAnswered.value && correctOne != 0){
                                if (correctOne == 4) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            } else if (!questionAnswered.value){
                                if (correctColor.value == 4) {
                                    answeredWell.value = true
                                }
                                questionAnswered.value = true
                            }
                        },
                        modifier = Modifier.background(Color.Green).size(200.dp, 75.dp)
                            .padding(10.dp)
                    ) {
                        Text(answer4, textAlign = TextAlign.Center)
                    }
                }
            }
        } else{
            if (correctOne != 0){
                Text(clueItsYourAnswerCorrect, textAlign = TextAlign.Center)
            } else{
                if (correctColor.value == 1){ Text("The color Red has come out") }
                else if (correctColor.value == 2){ Text("The color Blue has come out") }
                else if (correctColor.value == 3){ Text("The color Yellow has come out") }
                else{ Text("The color Green has come out") }
            }
            Button(onClick = {
                if (roundsCounter.value == rounds){
                    navigateToResultScreen(points.value)
                } else{
                    if (answeredWell.value){
                        if (correctOne == 0){
                            points.value += 2
                            correctColor.value = Random.nextInt(1, 5)
                        } else {
                            points.value ++
                        }
                        question.value++
                        roundsCounter.value++
                        answeredWell.value = false
                        questionAnswered.value = false
                    } else {
                        question.value++
                        roundsCounter.value++
                        questionAnswered.value = false
                    }
                }
            }){
                if (roundsCounter.value == rounds){
                    Text("Go back to menu")
                } else{
                    Text("Next Question")
                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        if (answeredWell.value){
            if (correctOne == 0){
                Text("Your points ${points.value + 2}", textAlign = TextAlign.Center)
            } else {
                Text("Your points ${points.value + 1}", textAlign = TextAlign.Center)
            }
        } else {
            Text("Your points ${points.value}", textAlign = TextAlign.Center)
        }
    }
}
