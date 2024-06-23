package project.elite.chatapplication.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import project.elite.chatapplication.R
import project.elite.chatapplication.navigation.Screens


@Composable
fun HomeScreen(navHostController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {


        Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {


            Text(text = "Welcome Back", color = Color.White, fontSize = 20.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Nandini!", color = Color.LightGray, fontSize = 20.sp)
        }




        LazyRow {
            items(5) {

                Spacer(modifier = Modifier.width(15.dp))
                Column {

                    Card(shape = CircleShape, modifier = Modifier.size(65.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.background),
                            contentDescription = ""
                        )
                    }



                    Text(text = "Nandini", color = Color.White)
                }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color = Color.White)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Divider(modifier = Modifier.width(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row (modifier = Modifier.clickable{navHostController.navigate(Screens.ChatScreen.route)}){

                    Card(shape = CircleShape, modifier = Modifier.size(65.dp)) {

                        Image(
                            painter = painterResource(id = R.drawable.background),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column (){
                        Text(text = "Nandini Singh")
                        Text(text = "message", fontSize = 15.sp, color = Color.Gray)
                    }

                }
                Column {

                    Text(text = "12:39am")
                    Icon(imageVector = Icons.Default.Check, contentDescription = "")
                }
            }

        }


    }
}
