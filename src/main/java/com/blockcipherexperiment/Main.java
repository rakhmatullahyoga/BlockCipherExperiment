/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakhmatullah Yoga S
 */
public class Main {
    public static void main(String[] args) {
        try {
            String repeatedText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456ABCDEFGHIJKLMNOPQRSTUVWXYZ123456";
            String longText = "Crop Circle Theories\n" +
"Crop circles are areas of cereal or similar crops that have been systematically flattened to form various geometric patterns. The phenomenon itself only entered the public imagination in its current form after the notable appearances in England in the late 1970s. Various scientific and pseudo-scientific explanations were put forward to explain the phenomenon, which soon spread around the world.\n" +
"In 1991, more than a decade after the phenomena began, two men, Doug Bower and Dave Chorley, revealed that they had been making crop circles in England since 1978 using planks, rope, hats and wire as their only tools. Many other people around the world are also openly making crop circles. Although the commonly accepted view today is that crop circles are a man-made phenomenon, paranormal explanations, often including UFOs, are still popular.";
            ModeSelection mode = new ModeSelection();
            System.out.println("============================");
            System.out.println("          ECB Mode");
            System.out.println("============================");
            mode.setKey("KOTABANDUNGJUARA");
            mode.setPlain(longText.toUpperCase().getBytes());
            mode.encryptECB();
            System.out.println("Hasil enkripsi:");
//            System.out.println(Tools.bytesToString(mode.getCipher()));
            System.out.println("Frekuensi:");
            mode.showCipherFrequency();
            System.out.println();
            mode.decryptECB();
            System.out.println("Plainteks hasil dekripsi:");
//            System.out.println(Tools.bytesToString(mode.getPlain()));
            System.out.println("Frekuensi:");
            mode.showPlainFrequency();
            System.out.println();
            System.out.println("============================");
            System.out.println("          CBC Mode");
            System.out.println("============================");
            mode.setKey("ABCDEFGHIJKLMNOP");
            mode.setPlain(longText.toUpperCase().getBytes());
            mode.encryptCBC();
            System.out.println("Hasil enkripsi:");
//            System.out.println(Tools.bytesToString(mode.getCipher()));
            System.out.println("Frekuensi:");
            mode.showCipherFrequency();
            System.out.println();
            mode.decryptCBC();
            System.out.println("Plainteks hasil dekripsi:");
//            System.out.println(Tools.bytesToString(mode.getPlain()));
            System.out.println("Frekuensi:");
            mode.showPlainFrequency();
            System.out.println();
            System.out.println("============================");
            System.out.println("          CFB Mode");
            System.out.println("============================");
            mode.setKey("ABCDEFGHIJKLMNOP");
            mode.setPlain(longText.toUpperCase().getBytes());
            mode.encryptCFB();
            System.out.println("Hasil enkripsi:");
//            System.out.println(Tools.bytesToString(mode.getCipher()));
            System.out.println("Frekuensi:");
            mode.showCipherFrequency();
            System.out.println();
            //mode.setPlain(null);
            mode.decryptCFB();
            System.out.println("Plainteks hasil dekripsi:");
//            System.out.println(Tools.bytesToString(mode.getPlain()));
            System.out.println("Frekuensi:");
            mode.showPlainFrequency();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        byte[] encByte = ClassicCipherTools.encryptByte(("Crop Circle Theories\n" +
//"Crop circles are areas of cereal or similar crops that have been systematically flattened to form various geometric patterns. The phenomenon itself only entered the public imagination in its current form after the notable appearances in England in the late 1970s. Various scientific and pseudo-scientific explanations were put forward to explain the phenomenon, which soon spread around the world.\n" +
//"In 1991, more than a decade after the phenomena began, two men, Doug Bower and Dave Chorley, revealed that they had been making crop circles in England since 1978 using planks, rope, hats and wire as their only tools. Many other people around the world are also openly making crop circles. Although the commonly accepted view today is that crop circles are a man-made phenomenon, paranormal explanations, often including UFOs, are still popular.\n" +
//"In paranormal circles the study of the crop circle phenomena is called Cerealogy. Cerealogists commonly refer to these designs as agriglyphs or landscape art.\n" +
//"Crop circles are found in fields, over tree-tops, and in ice and snow. They are mostly often found in wheat or corn fields, but have also been found in oat, rape (canola), and barley. They are a world wide phenomena, highlighted in England.\n" +
//"History of Crop Circles\n" +
//"No one knows how far back in history they go. Allegedly, the earliest recorded crop circle is depicted in this 1647 woodcut called the Mowing-Devil.\n" +
//"This image depicts a strange creature creating a circular design in a field of corn. The legend suggests that the farmer, disgusted at the wage his mower was demanding for his work, insisted that he would rather have the devil himself perform the task. Proponents of the belief that crop circles are either naturally caused, or are formed by as yet unknown entities, often support their viewpoint with this old tale. It is worth noting, however, that this is little more than a tale – the circular formation supposedly caused by the creature may be coincidental, or may have been caused by any number of natural or human processes.\n" +
//"An apparently more convincing historical report of crop circles was published in the journal Nature in 1880 (reproduced in 2000). An amateur scientist named Brandon Meland appears to describe a field containing a number of crop circles, along with his suggestion that they might have been caused by “some cyclonic wind action”.\n" +
//"Not long after WWII, the aerial surveys that were being made over large areas of Britain revealed some unexpected phenomena, undetectable from the ground. When the surveys photographed ripening crops or drought-stressed terrain they revealed what were soon termed “crop marks”, the differential ripening of the crop that revealed differences in the subsoil. These patterns were found to be caused by the buried remnants of ancient buildings. Archaeological investigations were soon instigated, but, though many previously unsuspected archaeological sites were found, no crop circles were ever recorded. Skeptics argue that this would have pointed to circles as a modern phenomenon, even if the initial pranksters had not revealed themselves; believers reply different agendas may simply be at work in the modern day.\n" +
//"Crop Circles shot into prominence in the late 1970s as many circles began appearing throughout the English countryside. To date, thousands of circles have appeared at sites across the world, from disparate locations such as the former Soviet Union, the UK and Japan, as well as the U.S. and Canada.\n" +
//"1991 – Barbury Castle Crop Circle\n" +
//"The first major “breakthrough” formation that departed from the original patterns was Barbury Castle 1991. Some researchers believe that the Barbury formation was the “Rosetta Stone” to the understanding of the geometric nature of the dimensions in the universe.\n" +
//"Creators of Crop Circles\n" +
//"In 1991, more than a decade after the phenomena began, two men announced that the phenomenon of crop circles was an idea thought up one evening in a pub in Southampton, England in 1978. World War II veteran Doug Bower and his friend Dave Chorley revealed that they made their crop circles using planks, rope, hats and wire as their only tools. Bower and Chorley stated to reporters that a small group of people can stomp down a sizeable area of crop in a single night. “Stomp” does not mean using the feet: simple tools to make crop circles have been demonstrated.\n" +
//"The pair became slightly frustrated that their work had not received as much publicity as they had hoped. In 1981 they created a crop circle in a highly visible area called the Winchester Punchbowl – an area surrounded by roads from which a clear view of the field is available to drivers passing by.\n" +
//"Bower’s wife had become increasingly suspicious of him due to noticing particularly high levels of road mileage in their car. Eventually, fearing that his wife suspected him of something else, Bower confessed to her what he had been doing and subsequently informed a British national newspaper.\n" +
//"Bower revealed on TV the method used, which was that of a four-foot-long plank with rope attached and circles of eight feet in diameter could be easily created. He stated that a 40-foot circle could be created by two men in a quarter of an hour. The designs were at first simple circles. When newspapers claimed that the circles could easily be explained by natural phenomena, Bower and Chorley chose more complex patterns. A simple wire with a loop, hanging down from a cap – the loop positioned over one eye – could be used to focus on a landmark to aid in the creation of straight lines.\n" +
//"Later designs of crop circles were to become increasingly complex. Dave Chorley died in 1996 though Doug Bower has made the occasional crop circle as recently as 2004 – over ten years after he revealed it to be a hoax. Bower has said that, had it not been for his wife’s suspicions, he would have taken the secret to his deathbed, never revealing that it was a hoax.\n" +
//"Circlemakers have demonstrated that making what self-appointed cerealogist experts state are “unfakeable” crop circles is possible. One such cerealogist, G. Terence Meaden, was filmed claiming that a crop circle was genuine when the night before the making of that crop circle by humans was filmed.\n" +
//"On the night of July 11-12, 1992, a crop-circle making competition, for a prize of several thousand pounds (partly funded by the Arthur Koestler Foundation), was held in Berkshire. The winning entry was produced by three helicopter engineers, using rope, PVC pipe, a trestle and a ladder. Another competitor used a small garden roller, a plank and some rope.\n" +
//"The size and complexity of the designs demonstrated that minimal equipment and preparation sufficed to produce even the most complex crop circle designs.Scientific American published an article by Matt Ridley (August 2002, p. 25), who started making crop circles in Texas in 1991. He wrote about how easy it is to develop techniques using simple tools that can easily fool later observers. He reported on “expert” sources such as the Wall Street Journal who had been easily fooled, and mused about why people want to believe supernatural explanations for phenomena that are not yet explained.\n" +
//"Methods to create a hoaxed crop circle have been well-documented on the Internet, there’s even a beginners guide.A counter argument to hoaxing is that where circles appear in crops mature enough that they carry seeds (as they do so often) seed-pods are unbroken, whereas trampling causes seed-pod breakage.\n" +
//"Crop circle hoaxers counter that it is easy to leave dry seed pods unbroken during stomping and also leave no trace of entrance and egress trampling when the plants and ground are both dry and some care is taken while walking.\n" +
//"Several crop circles, later to have been determined to be hoaxes, were at first certified as being ‘genuine’ by cerealogists due to the lack of seed pod breakage. Entry to a field without leaving traces is also easy, since there always are several tracks made by the machines used to spray insecticides on the crop that people can use.\n" +
//"Some claim that the circles might still have merit as a social phenomenon regardless of their legitimacy. New Age experts have expressed interest in researching the shapes and symbols depicted.\n" +
//"The first people to be charged with creating a crop circle were Hungarian teenagers Gabor Takacs and Robert Dallos, both 17 and from the St. Stephen Agricultural Technicum, a high school in Hungary specializing in agriculture. On the night of June 8th 1992 they created a 36 meter diameter crop circle in a wheat field near Szekesfehervar, 43 miles southwest of Budapest.\n" +
//"On September 3rd 1992 they appeared on a Hungarian TV show and exposed the circle as a hoax showing photos of the field before and after the circle was made. As a result Aranykalasz Co. the owners of the land that the corp circle was created on sued the youngsters for Fts.630,000 (approx 5,000 UK pounds) in damages. The court eventually ruled that the boys were only responsible for the damage caused in the 36 meters diameter circle, amounting to about Fts.6,000 (47 UK pounds).\n" +
//"They concluded that 99% of the damage to the crops was caused by the thousands of visitors that flocked to Szekesfehervar following the media’s promotion of the circle. The fine was eventually paid for by the TV show, as were the boys legal fees.\n" +
//"Some crop-circle photographs are hoaxes, created using image manipulation.\n" +
//"Despite the fact that many of the most complicated crop circles created are well documented human efforts, some enthusiasts argue that some designs have a degree of complexity that humans would not be able to easily recreate on paper let alone in a field at night.\n" +
//"They argue that the shapes of these formations are far too complex, and display a tremedously high level of symmetry which make it extremely difficult for a team of humans to create using just simple hand tools. Circle makers respond by noting that the only tool necessary for perfect symmetry is a measured length of rope rotated around a central pivot point.\n" +
//"In 1972 two witnesses, Arthur Shuttlewood and Bryce Bond, sat on the slope of Star Hill near Warminster, England, hoping to catch a glimpse of the strange unidentifyed flying craft that had made this part of England a UFO mecca for almost a decade. In the light of a full moon, from a distance of 100 feet, they allegedly witnessed a large circular area of plants that collapsed within twenty seconds creating a crop circle.\n" +
//"Crop formations are sometimes accompanied by sightings of unusual lights and structured craft beaming shafts of light onto the field the night before.\n" +
//"Very often crop formations appear where powerful ley lines intersect or the Earth’s magnetic energy lines. This is often at the same place where megalithic sites such as Stonehenge are found. Dowsing can be done within the formations after the crop has been plowed when there are no longer traces of physical evidence.\n" +
//"I believe the real formation are created by the grid consciousness that creates our reality their messages reflect creation and rebirth. This lends itself to creation by sound as reality manifests by sound harmonics. The concepts for the hoaxed patterns is also set in play by the same consciousness as an awakening tool. Reality is about the evolution of consciousness in the alchemy of time.\n" +
//"Crop Circles Designs\n" +
//"Early examples of this phenomenon were usually simple circular patterns of various sizes, which led some people to speculate that it was a natural phenomenon.\n" +
//"But after some years more and more elaborate and complex geometric patterns have emerged.\n" +
//"There have been many recurring themes over the years.\n" +
//"In general, the early formations (1970 – 2000) seemed to those who believe in a para-normal origin of the circles to be based on the principles of Sacred Geometry.\n" +
//"After the public admission of the original creators, Doug and Dave, crop circle activity skyrocketed. Each new design sought to be more complex than earlier designs.\n" +
//"Today crop circle designs have increased in complexity to the point where they have become an art form in and of themselves. John Lundberg, in an interview with Mark Pilkington, spoke about this change in crop circle designs, “I am rather envious of circlemakers in other countries. Expectations about the size and complexity of formations that appear in the UK are now very high, whereas the rather shabby looking Russian formation made the national news.\n" +
//"The Stonehenge Julia Set was first reported on 7 July, 1996. It measured 900 by 500 feet, with 151 circles. Julia Set The Treble Julia Set, widely felt to be the pinnacle of the crop circle formations in that year, was found on Windmill Hill near Yatesbury, Wiltshire in July 1996.\n" +
//"Later formations, those occurring after 2000, appear to be based on other principles, natural sciences and mathematics designs, including fractals.\n" +
//"Many crop circles have fine intricate detail, regular symmetry and careful composition.\n" +
//"Elements of three-dimensionality became more frequent, culminating in spectacular images of cube-shaped structures.\n" +
//"Maze, Cube and Squares, Complex Formation were found. Notice the size of the formation relative to the people lying in it. Crop illustrations which include cartoon characters have also appeared.\n" +
//"Contending Beliefs\n" +
//"Most critical observers, and the scientific mainstream, are convinced that crop circles are sniggles or hoaxes engineered by humans, and indeed more and more crop formations have been claimed by their makers. This explanation, supported by the documentation produced by some crop-circle hoaxers, has the advantage of not requiring the assumption of the existence of flying saucers or other as-yet-unobserved phenomena. However, there are many contending hypotheses which assume that at least some crop circles are not the products of mundane hoaxers; these hypotheses vary in their degree of scientific rigor, but all fall to some extent outside the mainstream.\n" +
//"One modern belief is that crop circles are created by flying saucers landing in fields and flattening a neat circle in the crop. However, the increasing complexity of formations from the 1980s on make this conjecture seem unlikely.\n" +
//"Some enthusiasts suggest that crop circle may be cymatics, the visualisation of vibration or sound.\n" +
//"According to this hypothesis, the complex patterns are two-dimensional geometric or visual representations of sound frequencies, with higher sound frequencies producing more complex shapes similar to both mandalas and crop circle designs.\n" +
//"Another hypothesis is that a man-made satellite in Earth orbit is using some kind of beam (e.g., microwaves) to create the designs.\n" +
//"Heating stems of wheat with a short intense burst of microwave energy can produce wilting similar to that in a crop circle.\n" +
//"Flattened stems often have the bend just below a stem-node, and also may feature blackened burn holes indicative of intense heating.\n" +
//"Microwave heating has been shown to be capable of producing these effects. It is postulated by believers of this theory that the U.S. Pentagon’s “Star Wars” program has a satellite capable of delivering such a microwave beam.\n" +
//"However, there is a reasonable counter-argument to this stating that there were no traces of supposed radiation detected in the crop circles.\n" +
//"Crops that were bent using the microwave technique showed all signs of various radiations and moisture differences. The original crops in the crop circle showed no abnormalities compared to normal crops, except for being mysteriously bent.\n" +
//"Furthermore, the “Star Wars” theory leads to the question “Why would a US military satellite be making patterns in crops across the world?” Such activity would be either a matter of official policy (in which case the question “why?” remains) or random acts by (bored?) military personnel, which would be tantamount to firing a major and highly secret weapon near populated areas, and would surely subject the perpetrator(s) to harsh disciplinary action.\n" +
//"Often touted as evidence for the mystic origin of crop circles is the coincidence that many circles in the Avebury area of southern England occur near ancient sites such as earth barrows or mounds, white horses carved in the chalk hills, and stone circles.\n" +
//"Other ideas on their formation have been proposed include tornadoes, freak wind patterns, ball lightning, and something called “plasma vortices”. A number of witnesses claim to have observed circles being created, saying that it takes a few seconds and the corn falls flat like a fan being opened – though these accounts are always anecdotal and have never been supported by any evidence beyond the claimants’ assertions.\n" +
//"Crop circle enthusiasts claim that there are other features of crop circles that undercut the hoax theory. They say that bends in the corn in many circles occur at the node, while the flattening of the corn by hoaxers produces a crack at any point in the stem, and some scientific studies on apical nodes bear them out.\n" +
//"Also they say that flattened corn often lies in groomed layers, rather than random crushings. While there have been cases in which believers declared crop circles to be “the real thing”, only to be confronted soon after with the people who created the circle and documented the fraud, the bending issue remains in dispute.\n" +
//"Electronic Equipment\n" +
//"There are numerous reports of electronic and mechanical equipment breaking down in crop circles. Cameras frequently malfunction, and even when they do work, the results may be overexposed, streaked, smeared, or entirely black. Video equipment is also very vulnerable, and often picks up severe interference. Battery draining is quite common, and even fresh power packs can die. Cell phones often fail to operate within a formation but sometimes work perfectly again if taken outside it.\n" +
//"Magnetic compasses frequently behave erratically both inside crop formations and when flying directly over them. Witnesses sometimes report TV, cell phone, smoke alarm and security device interference or malfunctions during nights when a crop circle forms nearby. The night before the appearance of the 1991 Barbury Castle tetrahedron), residents in the nearby village of Broughton experienced a power blackout and many residents reported balls of coloured light flying above the field where the formation later manifested, along with a low rumbling noise.").getBytes(), "ABCDEFGHIJKLMNOP");
//        String enc = Tools.bytesToString(encByte);
//        String dec = Tools.bytesToString(ClassicCipherTools.decryptByte(encByte, "ABCDEFGHIJKLMNOP"));
//        System.out.println(dec);
    }
}
