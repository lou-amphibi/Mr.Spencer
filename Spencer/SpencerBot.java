package Spencer;

import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

// botname: Mr.Spencer username: Mr_SpencerBot @username t.me/Mr_SpencerBot 
public class SpencerBot extends TelegramLongPollingBot {
 
	boolean hasStarted = true;
	boolean hasPeriod = true;
	String period = null;
	
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new SpencerBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public String getBotUsername() {
		return "Mr_SpencerBot";
	}
 
	@Override
	public String getBotToken() {
		return "Token";
	}
 
	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		
		if (message.getText().equals("/help")) {
			sendMsg(message, "Вы читайте и жмете на соответствующие цифры, а я показываю вам цитаты\n/start - запуск\n/help - справка\n"
					+ "/github - ссылка на github\n/skip - для начала работы c начала");
			return;
		}
		
		if (message.getText().equals("/github")) {
			sendMsg(message, "https://github.com/lou-amphibi/Mr.Spencer");
			return;
		}
		
		if (message.getText().equals("/skip")) {
			sendMsg(message, "Каждый должен жить, не обременяя собою других и не принося им вреда");
			hasStarted = true;
			hasPeriod = true;
			period = null;
			return;
		}
		
		if (hasStarted) { 
			if (message.getText().equals("/start")) {
				startMessage(message);
				hasStarted = false;
			} else
				sendMsg(message, "Я преисполняюсь в познании после /start\n/help для справки");	
			return;
		}
		
		if (!checkChoice(message) && hasPeriod) {
			startMessage(message);
			return;
		}
		
		if (hasPeriod) {
			String choice = message.getText();
			sendMsg(message, "Выберите интересующего вас философа:");
			switch (choice) {
				case "1":   
					periodOne(message);
					period = "1";
					break;
				case "2":  
					periodTwo(message);
					period = "2";
					break;
				case "3":
					periodThree(message);
					period = "3";
					break;
				case "4":
					periodFour(message);
					period = "4";
					break;
				case "5":
					periodFive(message);
					period = "5";
					break;
			}
			hasPeriod = false;
			return;
		}
		
		
		String choice = message.getText();
		
		if (period.equals("1")) {
			switch (choice) {
				case "1":
					sendMsg(message, "Все есть вода");
					break;
				case "2":
					sendMsg(message, "Части изменяются, целое же неизменно");
					break;
				case "3":
					sendMsg(message, "Дыхание и воздух объемлют весь космос. Из них всё возникает и в них всё разрешается");
					break;
				case "4":
					sendMsg(message, "С тиранами нужно говорить или как можно меньше, или как можно слаще");
					break;
				case "5":
					sendMsg(message, "Учите математику и не ешьте бобы!\nКак ни коротки слова «да», «нет», все же они требуют самого серьезного размышления");
					break;
				case "6":
					sendMsg(message, "Мыслить и быть - одно и то же");
					break;
				case "7":
					sendMsg(message, "Я только и делаю, что думаю об отечестве (указывая на небо)");
					break;
				case "8":
					sendMsg(message, "Хороший друг должен на веселие являться по зову, на бедствие же друга приходить без зова");
					break;
				default: 
					sendMsg(message, "Выберите интересущего вас философа");
					periodOne(message);
					return;
					
				}
			hasStarted = true;
			hasPeriod = true;
		} else if (period.equals("2")) {
			switch (choice) {
				case "1": 
					sendMsg(message, "Природа наделила нас двумя глазами, двумя ушами, но лишь одним языком, дабы мы смотрели и слушали больше, чем говорили");
					break;
				case "2":
					sendMsg(message, "Никто не становится хорошим человеком случайно");
					break;
				case "3":
					sendMsg(message, "Солдат должен бояться своего начальника больше, чем врагов");
					break;
				case "4":
					sendMsg(message, "То, что принято без доказательств, может быть отвергнуто без доказательств");
					break;
				case "5":
					sendMsg(message, "Я дам тебе милостыню, Диоген, если ты убедишь меня сделать это. — "
							+ "Если бы я мог хоть в чем-то тебя убедить, я бы убедил тебя повеситься!");
					break;
				case "6":
					sendMsg(message, "Жизнь может казаться благом только безумцу");
					break;
				case "7":
					sendMsg(message, "Законы молчат среди лязга оружия");
					break;
				case "8":
					sendMsg(message, "Да будет все к лучшему; но ежели что-нибудь случится, то Аристотель распорядился так");
					break;
				default: 
					sendMsg(message, "Выберите интересущего вас философа");
					periodTwo(message);
					return;
			}
			hasStarted = true;
			hasPeriod = true;
		} else if (period.equals("3")) {
			switch (choice) {
				case "1":
					sendMsg(message, "От доказательств вера тверже быть не может");
					break;
				case "2":
					sendMsg(message, "Бог избавляет нас от скорбей не таким образом, что более не посещают нас никакие скорби");
					break;
				case "3":
					sendMsg(message, "Великая бездна – сам человек, волосы его легче счесть, чем его чувства и движения сердца");
					break;
				case "4":
					sendMsg(message, "Ежедневно умирай, чтоб жить вечно: потому что боящийся Бога жив будет во веки");
					break;
				case "5":
					sendMsg(message, "И у души есть смерть, хотя она бессмертна по естеству");
					break;
				case "6":
					sendMsg(message, "Истина есть и в таких вещах, в коих нет блага, например в математике");
				case "7":
					sendMsg(message, "Ничто не должно приниматься без основания, если оно не известно или как самоочевидное, или по опыту");
					break;
				case "8":
					sendMsg(message, "Любовь не ищет вовне ни причины, ни пользы: ее польза в самом ее проявлении");
					break;
				default: 
					sendMsg(message, "Выберите интересущего вас философа");
					periodThree(message);
					return;
			}
			hasStarted = true;
			hasPeriod = true;
		} else if (period.equals("4")) {
			switch (choice) {
				case "1":
					sendMsg(message, "Всякое исследование основано на сравнении и пользуется средством сопоставлений");
					break;
				case "2":
					sendMsg(message, "Благоразумию также свойственны крайности, и оно не меньше нуждается в мере, чем легкомыслие");
					break;
				case "3":
					sendMsg(message, "Невежество — лучшая в мире наука, ибо даётся без труда и не печалит душу");
					break;
				case "4":
					sendMsg(message, "Людей следует либо ласкать, либо изничтожать, ибо за малое зло человек может отомстить, а за большое — не может");
					break;
				case "5":
					sendMsg(message, "Все мы ценим добро, лишь теряя его невозвратно");
				case "6":
					sendMsg(message, "Никакой авторитет не должен господствовать над разумом; разум, напротив, "
							+ "должен господствовать над авторитетом и управлять им");
					break;
				case "7":
					sendMsg(message, "Говорить путанно умеет всякий, говорить ясно — немногие");
					break;
				case "8":
					sendMsg(message, "Бог вовсе не должен страдать из-за тупости своего священника (И если пастырь туп, страдать не должен Бог)");
					break;
				default: 
					sendMsg(message, "Выберите интересущего вас философа");
					periodFour(message);
					return;
			}
			hasStarted = true;
			hasPeriod = true;	
		} else if (period.equals("5")) {
			switch (choice) {
				case "1":
					sendMsg(message, "Один из секретов природы и политики состоит в том, что безопаснее менять много вещей, чем одну");
					break;
				case "2":
					sendMsg(message, "Здравый смысл кажется единственной вещью, которая во всём мире распределена равномерно —"
							+ " никто не хочет его больше, чем у него есть");
					break;
				case "3":
					sendMsg(message, "Величие не в том, чтобы впадать в крайность, но в том, чтобы касаться "
							+ "одновременно двух крайностей и заполнять промежуток между ними.");
					break;
				case "4":
					sendMsg(message, "Когда остаешься один, нужно точно знать, с кем ты остаешься");
					break;
				case "5":
					sendMsg(message, "Доказанное примерами никогда нельзя считать полностью доказанным");
					break;
				case "6":
					sendMsg(message, "Тот, кто становится пресмыкающимся червем, может ли потом жаловаться, что его раздавили");
					break;
				case "7":
					sendMsg(message, "В самой сущности человека заложено, что его последняя цель должна быть недостижимой, а его путь к ней - бесконечным");
					break;
				case "8":
					sendMsg(message, "Жестокость характерна для законов, продиктованных трусостью, ибо трусость может "
							+ "быть энергична, только будучи жестокой. Частный интерес всегда труслив, "
							+ "ибо для него сердцем, душой является внешняя вещь, которая всегда может быть отнята или повреждена");
					break;
				case "9":
					sendMsg(message, "Порвать со своими богами, со своими предками, со своим языком и страной, порвать со всем — разумеется, это ужасное испытание; но в то же"
							+ " время это восхитительный опыт, пережить который так жадно стремятся перебежчики и, еще больше, предатели.");
					break;
				case "10":
					sendMsg(message, "Одни созданы для того, чтобы любить, другие — для того, чтобы жить");
					break;
				case "11":
					sendMsg(message, "Препятствование самоубийству. Существует право, по которому мы можем отнять у человека жизнь, "
							+ "но нет права, по которому мы могли бы отнять у него смерть; это есть только жестокость");
					break;
				case "12":
					sendMsg(message, "Если бессмыслицы, какие нам приходится выслушивать в разговоре, начинают сердить нас, надо вообразить, что "
							+ "это разыгрывается комическая сцена между двумя дураками; это испытаннейшее средство.");
					break;
				case "13":
					sendMsg(message, "Когда мы хотим проникнуть в неразрешимую тайну сущности происхождения явлений, то мы не можем придумать ничего более удовлетворительного, как приписать "
							+ "их внутренним или внешним хотениям, уподобляя их, таким образом, повседневным проявлениям волнующих нас страстей");
					break;
				case "14":
					sendMsg(message, "Многие люди думают, будто они мыслят, тогда как на самом деле они всего лишь расставляют старые предрассудки в новом порядке");
					break;
				default: 
					sendMsg(message, "Выберите интересущего вас философа");
					periodFive(message);
					return;
			}
			hasStarted = true;
			hasPeriod = true;	
		}
	}
	
 
	private void sendMsg(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkChoice(Message message) {
		if (message.getText().equals("1") || message.getText().equals("2") || message.getText().equals("3")
				|| message.getText().equals("4") || message.getText().equals("5") )
			return true;
		return false;
				
	}
	
	private void startMessage(Message message) {
		sendMsg(message, "Выберите интересующий ваc период, введя его номер:\n1) Досократики. Период становления (VII–V века до нашей эры)\n"
				+ "2) Античная философия (VI век до н.э. - V век нашей эры)\n"
				+ "3) Средневековая философия (V век н. э. - XIV век н.э.)\n"
				+ "4) Возрождение (XIV век н.э.- XVI век н.э.)\n"
				+ "5) Философия Нового времени. Буржуазная классическая философия (XVII век н.э. - конец XX века н.э)\n");
	}
	
	private void periodOne(Message message) {
		sendMsg(message, "1) Фалес\n"
				+ "2) Анаксимандр\n"
				+ "3) Анаксимен\n"
				+ "4) Ксенофан\n"
				+ "5) Пифагор\n"
				+ "6) Парменид\n"
				+ "7) Анаксагор\n"
				+ "8) Демокрит\n");
	}
	
	private void periodTwo(Message message) {
		sendMsg(message, "1) Сократ\n"
				+ "2) Платон\n"
				+ "3) Клеарх\n"
				+ "4) Евклид\n"
				+ "5) Диоген Синопский\n"
				+ "6) Гегесий\n"
				+ "7) Цицерон\n"
				+ "8) Аристотель\n");
	}
	
	private void periodThree(Message message) {
		sendMsg(message, "1) Тит Флавий Клемент\n"
				+ "2) Ориген\n"
				+ "3) Августин Блаженный\n"
				+ "4) Антоний Великий\n"
				+ "5) Григорий Палама\n"
				+ "6) Фома Аквинский\n"
				+ "7) Уильям Оккам\n"
				+ "8) Бернар Клервоский\n");
	}
	
	private void periodFour(Message message) {
		sendMsg(message, "1) Николай Кузанский\n"
				+ "2) Мишель Монтель\n"
				+ "3) Джордано Бруно\n"
				+ "4) Никколо Макиавелли\n"
				+ "5) Томас Мор\n"
				+ "6) Пьер де ла Рамэ\n"
				+ "7) Галилео Галилей\n"
				+ "8) Вольтер\n");
	}
	
	private void periodFive(Message message) {
		sendMsg(message, "1) Френсис Бекон\n"
				+ "2) Рене Декарт\n"
				+ "3) Блез Паскаль\n"
				+ "4) Бенедикт Спиноза\n"
				+ "5) Готфрид Вильгельм Лейбниц\n"
				+ "6) Иммануил Кант\n"
				+ "7) Фихте\n"
				+ "8) Карл Маркс\n"
				+ "9) Эмиль Чоран\n"
				+ "10) Альбер Камю\n"
				+ "11) Фридрих Ницше\n"
				+ "12) Артур Шопенгауэр\n"
				+ "13) Огюст Конт\n"
				+ "14) Уильям Джеймс\n");
	}
   
}
