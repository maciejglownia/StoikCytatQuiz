package pl.glownia.maciej.stoikcytatquiz

import android.os.Build

object QuestionsRandomizer {

    fun getRandomLimitedNumberOfQuestions(
        numberOfQuestionsToDisplay: Int
    ): ArrayList<Question> {
        val questionsList = getQuestion()
        // To have numbers of questions as equals above it need to subtract this value from arraylist size
        val randomElements =
            questionsList
                .asSequence()
                .take(questionsList.size.minus(numberOfQuestionsToDisplay))
                .toList()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            questionsList.removeIf { question -> randomElements.contains(question) }
        }
        questionsList.shuffle()
        return questionsList
    }

    private fun getQuestion(): ArrayList<Question> {
        val questionListTest = ArrayList<Question>()
        val numberOfQuestions = quotes().size
        for (i in 1..numberOfQuestions) {
            val question = Question(
                i,
                questionContent(),
                quotes().getValue(i),
                possibilityAnswers().getValue(1),
                possibilityAnswers().getValue(2),
                possibilityAnswers().getValue(3),
                possibilityAnswers().getValue(4),
                correctAnswers().getValue(i)
            )
            questionListTest.add(question)
        }
        questionListTest.shuffle()
        return questionListTest

    }

    private fun questionContent(): String {
        return "Czyje to słowa?"
    }

    private fun quotes(): Map<Int, String> {
        return mapOf(
            1 to "''Wiele jest ziarenek kadzielnych na jednym ołtarzu. Jedne najpierw wpadają, inne później. A to nie stanowi różnicy.''",
            2 to "''Nie same zdarzenia budzą w ludziach niepokój, ale sądy o nich.''",
            3 to "''Lepiej jest sporządzić bilans dotyczący własnego życia, niż rynku zbóż.''",
            4 to "''Uważam cię za pechowca, ponieważ nigdy nie zmierzyłes się z przeciwnościami losu. Przeszedłeś przez życie bez przeciwnika. Nikt, nawet ty, nie wie do czego jesteś zdolny.''",
            5 to "''Został osadzony w więzieniu. Jednak spostrzeżenie ''spotkało go zło'' dodałeś już sam.''",
            6 to "''Mamy dwoje uszu i jedne usta, abyśmy słuchali dwa razy tyle, co mówili.''",
            7 to "''Skutki gniewu są dużo poważniejsze od jego przyczyny.''",
            8 to "''Fortuna pragnie abym miał więcej wolności by filozofować. (Na wieść o zatonięciu statku z prawie całym majątkiem).''",
            9 to "''Chętnego Losy prowadzą, niechętnego wloką.''",
            10 to "''Lekarstwem na przyzwyczajenie jest inne przyzwyczajenie.''",
            11 to "''Jeśli chcesz być czytelnikiem, czytaj, jeśli pisarzem, pisz.''",
            12 to "''Mędrzec nie będzie twierdzić tego, co mu się tylko wydaje, i dzięki temu nigdy nie przytaknie fałszowi.''",
            13 to "''Na tym właśnie polega dzielność szczęśliwego i pogodnego życia, że wszystko się czyni zgodnie z własnym głosem wewnętrznym i z wolą rządcy Wszechświata.''",
            14 to "''Ten, kto więcej grzeszy, i ten, kto mniej grzeszy, są równie dalecy od dobrego postępowania.''",
            15 to "''Czyż ból i życie nie są sobie pokrewne?''",
            16 to "''Celem człowieka jest rozważny wybór rzeczy, które są zgodne z naturą.''",
            17 to "''Błąd obcy pozostaw u jego źródła.''",
            18 to "''Nie należy sie gniewać na bieg wypadków. Nic ich to bowiem nie obchodzi.''",
            19 to "''Szpetne jest, by twarz była umysłowi podległa i według jego rozkazu układała się i stawała piękną, a by umysł nie układał się na swój rozkaz własny i nie upiększał.''",
            20 to "''Wsiadłeś na okręt, użyłeś podróży, dobiłeś do portu. Wysiądź!''",
            21 to "''Najlepszym lekarstwem na gniew jest zwłoka.''",
            22 to "''Panować nad sobą to najwyższa władza.''",
            23 to "''Ludzie nauczając, uczą się.''",
            24 to "''Życie bez celu jest błądzeniem.''",
            25 to "''Z życiem jak ze sztuką w teatrze: ważne nie jak długo trwa, ale jak zagrana.''",
            26 to "''Z bliska zazwyczaj lęk jest mniejszy.''",
            27 to "''Najpierw naucz się znaczenia tego, co chcesz powiedzieć, a dopiero potem mów.''",
            28 to "''Nic tak nie zadziwia ludzi, jak zdrowy rozsądek i proste działanie.''",
            29 to "''Nie usiłuj naginać biegu wydarzeń do swojej woli, ale naginaj wolę do biegu wydarzeń, a życie upłynie ci w pomyślności.''",
            30 to "''Raz zobaczyć jakąś rzecz znaczy więcej, niż sto razy o niej słyszeć.''",
            31 to "''Skromnie przyjmować, spokojnie tracić.''",
            32 to "''Śmieszne to, że nie usuwamy się przed grzechem własnym, co jest możliwe, a usuwamy się przed obcym, co jest niemożliwe.''",
            33 to "''Zastanów się, o ile częściej cierpisz z powodu swego gniewu i żalu, niż z powodu rzeczy, które wprawiają cię w gniew i wzbudzają żal.''",
            34 to "''Duszyczką jesteś, dźwigającą trupa – powiedział Epiktet.''",
            35 to "''Jako cesarz jestem pierwszy w Rzymie, jako człowiek jestem równy wszystkim ludziom na świecie.''",
            36 to "''Możesz zacząć życie nowe. Jeszcze raz przyjrzyj się sprawom tak, jak zwykłeś to czynić. Na tym bowiem polega odrodzenie życia.''",
            37 to "''Najtrudniej dotrzeć do siebie samego.''",
            38 to "''Nie godzi się, aby twoja dusza czuła się zmęczona tym życiem, zanim nie zmęczy się nim ciało.''",
            39 to "''Nie czyń nic bez rozwagi, lecz tylko według zasady dobrze obmyślanej.''",
            40 to "''O własnych stój siłach – nie zaś podtrzymywany.''",
            41 to "''Polub twoją pracę, nawet gdyby była mało znacząca i odpoczywaj przy niej.''",
            42 to "''Wnet zapomnienie o wszystkim przyjdzie na ciebie i wnet zapomnienie wszystkich o tobie.''",
            43 to "''Trzeba ludzi znosić, jeśli nie umie się ich poprawić.''",
            44 to "''Powinniśmy wybierać się na przechadzki, tak by odżywić i odświeżyć umysł dzięki świeżemu powietrzu i głębokim oddechom.''",
            45 to "''Nie żyj tak, jakbyś miał żyć lat dziesięć tysięcy. Los wisi nad tobą. Dopóki żyjesz, dopóki możesz – bądź dobry.''",
            46 to "''Często popełnia nieprawość ten, kto czegoś nie robi, nie tylko ten, kto coś robi.''",
            47 to "''Dla kamienia rzuconego w górę nie jest niczym złym, że spadł na dół, ani dobrym, że go podrzucono.''",
            48 to "''Bacz, byś nie postępował tak wobec ludzi niemających uczuć ludzkich, jak ludzie niemający uczuć ludzkich wobec ludzi.''",
            49 to "''Budząc się rano, pomyśl jaki to wspaniały skarb żyć, oddychać i móc się radować.''",
            50 to "''Co nie jest pożyteczne dla roju, i dla pszczoły nie jest pożyteczne.''",
            51 to "''Człowiek tyle jest wart, ile warte są sprawy, którymi się zajmuje.''",
            52 to "''Dopóki żyjesz, dopóki można, bądź dobry.''",
            53 to "''Czy nie wstyd ci poświęcać dla siebie tylko ochłapów życia i przeznaczać na mądrość tylko ten czas, którego nie można wykorzystać na interesy?''",
            54 to "''Niezdobytą warownię przedstawia dusza wolna od namiętności.''",
            55 to "''Nigdzie bowiem nie schroni się człowiek spokojniej i łatwiej jak do duszy własnej.''",
            56 to "''Tak należy wszystko czynić i mówić, i o wszystkim myśleć, jakby się już miało odejść z życia.''",
            57 to "''Zajrzyj w siebie! W twoim wnętrzu jest źródło, które nigdy nie wyschnie, jeśli potrafisz je odszukać.''",
            58 to "''Jakże łatwo odtrącić od siebie i odepchnąć wszelkie wyobrażenia niepokojące i niestosowne i natychmiast uzyskać pogodę ducha.''",
            59 to "''Każdą pracę wykonuj, jakby miała ona być ostatnią w życiu.''",
            60 to "''Najlepszym sposobem obrony jest nie odpłacać pięknym za nadobne.''",
            61 to "''Zwycięstwo bez możliwości klęski jest zwycięstwem bez chwały.''",
            62 to "''Człowiek przede wszystkim musi mieć uczciwą samoocenę, ponieważ, często uważamy, że potrafimy zrobić więcej, niż w rzeczywistości możemy.''",
            63 to "''Żyj w czasie – niezależny od czasu.''",
            64 to "''Wędrowiec idący drogą dochodzi do jakiegoś końca: tylko błądzenie nie ma kresu.''",
            65 to "''Uczymy się nie dla szkoły, lecz dla życia.''",
            66 to "''To, co zdobyliśmy z największym trudem, najbardziej kochamy.''",
            67 to "''Przeciwności losu uczą mądrości, powodzenie ją odbiera.''",
            68 to "''Pojedyncze dni uważaj za osobne żywoty.''",
            69 to "''Nie ma nic niemądrzejszego niż oczekiwanie nieszczęść.''",
            70 to "''Obfite pożywienie hamuje bystrość umysłu.''",
            71 to "''Oszczędność jest to umiejętność unikania zbędnych wydatków.''",
            72 to "''Połowa wyzdrowienia to chcieć wyzdrowieć.''",
            73 to "''Porywczość jest grzechem niedojrzałości.''",
            74 to "''Codziennie umieramy, codziennie bowiem uszczupla się jakaś część życia.''",
            75 to "''Gdy nie wiesz, do którego portu płyniesz, żaden wiatr nie jest dobry.''",
            76 to "''Kiedy lekarstwo jest haniebne, wstyd przychodzić do zdrowia.''",
            77 to "''Czy jest coś gorszego niżeli śmierć? Życie, jeśli pragniesz umrzeć.''",
            78 to "''Mało jest takich, których zmuszono do niewoli, więcej tych, co dobrowolnie w nią idą.''",
            79 to "''Na przyszłość zastanawiaj się nie tylko nad tym, czy prawdą jest to, co mówisz, lecz czy ten, do kogo mówisz wytrzyma prawdę.''",
            80 to "''Najgorsze dla nas jest właśnie to, że wykazujemy starczą powagę, a dziecięce wady.''",
            81 to "''Nie należy ani okrętu przytwierdzać do jednej kotwicy, ani życia opierać na jednej nadziei.''",
            82 to "''Jeśli chcesz czynić postępy w mądrości, musisz się cieszyć z tego, że w oczach wilu będziesz uchodził za głupca.''",
            83 to "''Jeśli podejmiesz się roli ponad siły, nie tylko źle ją odegrasz, ale również zaniechasz innej, którą mógłbyś dobrze odegrać.''",
            84 to "''Jeśli nie chcesz, aby twe namiętności cię chłostały, chłoszcz je ty.''",
            85 to "''Wytrwaj i opanuj się.''",
            86 to "''W czasie uczty nie opowiadaj jak należy jeść, ale jedz jak należy.''",
            87 to "''Kiedy wady innych sprawiają ci przykrość, spójrz na siebie i zastanów się nad twoimi własnymi. Zajmując się nimi, zapomnisz o złości i nauczysz się żyć mądrze.''",
            88 to "''Zło to nie zdarzenie, które cię spotyka, lecz to, co robisz z tym zdarzeniem.''",
            89 to "''Naszego spokoju nie może zakłócić nic z zewnątrz. Cierpimy tylko wtedy, gdy pragniemy, aby było inaczej, niż jest. ''",
            90 to "''Cierpienie głupca leczy czas, cierpienie mędrca - rozum.''",
            91 to "''Jeżeli ktoś ci oznajmi, że jakiś człowiek źle mówi o tobie, nie broń sie przeciw zarzutom ale odpowiedz: na pewno nie wiedział on o innych błędach, w przeciwnym razie nie mówiłby tylko o tych.''",
            92 to "''Powinniśmy mieć zasady gotowe do zastosowania w każdej okoliczności.''",
            93 to "''Najpierw powiedz do siebie, jaki mógłbyś być, a potem zrób to co musisz zrobić.''",
            94 to "''Największą przysługę oddacie Państwu, podnosząc nie dachy domów, ale dusze współobywateli.''",
            95 to "''Prawdziwym panem i królem jest jedynie mędrzec, który uwolnił się od namiętności i niczego nie potrzebuje.''",
            96 to "''Tylko ludzie intelektualnie rozwinięci są wolni.''",
            97 to "''Każdy żyje tylko tą oto teraźniejszością, chwilką. Wszystko zaś inne alboś przeżył, albo niepewne.''",
            98 to "''Boją sie ludzie przemiany. A co może dziać się bez przemiany? Co jest milsze i zwyklejsze dla wszechnatury? Możesz-że się wykąpać, jeżeli drzewo nie ulega przemianie?''",
            99 to "''Nie jesteś ani swym ciałem, ani uczesaniem, lecz umiejętnością dokonywania słusznych wyborów. Jeśli twe wybory są piękne, ty też taki będziesz.''",
            100 to "''Podobny bądź do skały, o którą się ciągle fale rozbijają. A ona stoi, a koło niej usypiają bałwany wody.''"
        )
    }

    private fun possibilityAnswers(): Map<Int, String> {
        return mapOf(
            1 to "Epitktet z Hierapolis",
            2 to "Marek Aureliusz",
            3 to "Seneka Młodszy",
            4 to "Zenon z Kition"
        )
    }

    private fun correctAnswers(): Map<Int, Int> {
        return mapOf(
            1 to 2,
            2 to 1,
            3 to 3,
            4 to 3,
            5 to 1,
            6 to 4,
            7 to 2,
            8 to 4,
            9 to 4,
            10 to 1,
            11 to 1,
            12 to 4,
            13 to 4,
            14 to 4,
            15 to 4,
            16 to 4,
            17 to 2,
            18 to 2,
            19 to 2,
            20 to 2,
            21 to 3,
            22 to 3,
            23 to 3,
            24 to 3,
            25 to 3,
            26 to 3,
            27 to 1,
            28 to 1,
            29 to 1,
            30 to 1,
            31 to 2,
            32 to 2,
            33 to 2,
            34 to 2,
            35 to 2,
            36 to 2,
            37 to 2,
            38 to 2,
            39 to 2,
            40 to 2,
            41 to 2,
            42 to 2,
            43 to 2,
            44 to 3,
            45 to 2,
            46 to 2,
            47 to 2,
            48 to 2,
            49 to 2,
            50 to 2,
            51 to 2,
            52 to 2,
            53 to 3,
            54 to 2,
            55 to 2,
            56 to 2,
            57 to 2,
            58 to 2,
            59 to 2,
            60 to 2,
            61 to 3,
            62 to 3,
            63 to 3,
            64 to 3,
            65 to 3,
            66 to 3,
            67 to 3,
            68 to 3,
            69 to 3,
            70 to 3,
            71 to 3,
            72 to 3,
            73 to 3,
            74 to 3,
            75 to 3,
            76 to 3,
            77 to 3,
            78 to 3,
            79 to 3,
            80 to 3,
            81 to 1,
            82 to 1,
            83 to 1,
            84 to 1,
            85 to 1,
            86 to 1,
            87 to 1,
            88 to 1,
            89 to 1,
            90 to 1,
            91 to 1,
            92 to 1,
            93 to 1,
            94 to 1,
            95 to 1,
            96 to 1,
            97 to 2,
            98 to 2,
            99 to 1,
            100 to 2
        )
    }
}