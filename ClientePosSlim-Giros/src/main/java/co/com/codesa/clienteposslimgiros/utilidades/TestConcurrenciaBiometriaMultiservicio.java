package co.com.codesa.clienteposslimgiros.utilidades;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;
import co.com.codesa.codesawrapper.seguridad.MessageManager;
import co.com.codesa.codesawrapper.seguridad.Rescuer;

public class TestConcurrenciaBiometriaMultiservicio {


	public static void main(String args[]) throws Exception{
		
		new TestConcurrenciaBiometriaMultiservicio().pruebaSocketSIMSTramasBiometriaMultiservicio();
	}
	
	public void pruebaSocketSIMSTramasBiometriaMultiservicio()
		throws Exception
	{
		new Thread(
			new Runnable() {
				public void run() {
					try{
					
						String strRespuesta;
						String strTrmValidarTercero;
						
						strTrmValidarTercero = "9000847779,B,C,8|800249355|C0A7AE7D513F4BEB2BC203D6F339F1B5,530,1004578360,52001096,25312,1,ValidarTerceroBiometriaMultiServicio,CC;1144029966;SUPERGIROS;SUPERSERVICIOS_DE_NARINO_S_A;VENTA;BNET_POSSLIM;GIROS;ENVIO;CLIENTE;";
						System.out.println("HiloValidarTercero-->"+strTrmValidarTercero);
						strRespuesta = sendSocketClient("10.18.1.160", "2009", 6000, strTrmValidarTercero);
						System.out.println("HiloValidarTercero<--"+strRespuesta);
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			} 
			).start();
		
		new Thread(
				new Runnable() {
					public void run() {
						try{
						
							String strRespuesta;
							String strTrmTransmitirArchivo;
							
							strTrmTransmitirArchivo = "9000847779,B,C,8|800249355|C0A7AE7D513F4BEB2BC203D6F339F1B5,530,1004578360,52001096,25312,4,TransmitirArchivoBiometriaMultiServicio,CC;1006071500;SUPERGIROS;SUPERSERVICIOS_DE_NARINO_S_A;VENTA;BNET_POSSLIM;GIROS;ENVIO;WSQ_HUELLA;ID|CV1113661649|1532532903028;CC_1006071500_CV1113661649_1532532890365.wsq;image/compressed;/6D/qAB3TklTVF9DT00gOQpQSVhfV0lEVEggMzAwClBJWF9IRUlHSFQgNDAwClBJWF9ERVBUSCA4ClBQSSA1MDAKTE9TU1kgMQpDT0xPUlNQQUNFIEdSQVkKQ09NUFJFU1NJT04gV1NRCldTUV9CSVRSQVRFIDAuNzUK/6gAAv+kADoJBwAJMtMmPAAK4PMahAEKQe/xvAELjidlPwAL4Xmk3QAJLv9V0wEK+TPRtgEL8ocfNwAKJnfaDP+lAYUCACwCGssCICcCGssCICcCGssCICcCGssCICcCHBgCIbcCHFYCIgACGmgCH7ACHQICIs8D8nsCHRkD9zYCHaoD788CHMcCHY0CI3YCGiECH1sCGbMCHtcCGbcCHtsD/GMCHkkD+qUCHhQCGe0CHxwCGdECHvsD+AgCHcQCHccCI7wCGfUCHyYCHZkCI4QCHdgCI9ACIHkCJvgCHwECJTUCIE0CJsMCHJkCIlECH6gCJf0CHO0CIrYCHvsCJS0CIFECJscCIagCKGMCINgCJ2oCIiYCKPsCHkoCJFkCHGQCIhICIS8CJ9ICH6ACJfQCHKICIlwCHfgCI/cCIZgCKFACIFkCJtECIFICJsgCIbcCKHUCKIkCMKQCJIsCK9oCIvsCKfoCIkoCKSUCJ3ACL1MCJssCLo0CJNYCLDMCHCYCIcgCJOoCLEwCHPICIrwCKUsCMY0CIcgCKIkCH/cCJlwCMQICOs8CMtYCPQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD/ogARAP8BkAEsAkZlBDb/AAAA/6YAWwAAAgECAgUFCQoJCAQPAAAAs7UBsrYCsQMEsLe4BQauuboHCAmsra+7vL0KDKirvr/Aw8TFCw4Qn6Clp6rCDSOeoaKkpsEenaOpDxESICIkJjA2Nz5CmZrH/6MAAwD6/wAfP4/4/P4fP6/X6/XP6fp+n9N/t9vt7f4/2/t+f9s/f7f/ALb9f7f1/T+/w+v2+3x/b9P9f6f16fx9/l+v9vz/APn5/r5/x9/n+/6f/f8AX/b+/j/H3+nw/P8Ap/X+/lv9fv8Aavh+37eNdvv9/v6Zd+PX5ff7ff8Az6enHt7fP7/b7fb5/T5fL5fx9vt9vt9fr/n+Pr9vt9pSHG+m7p5uOlko6nHnGDQ2Zx6UbVnK+mSmMvgKTfZKxuSiMZtTaxm2GnUwfyRMmrYw1SNHKxz1YqmhAqyhcEcdHRvRrS4PU5Bh5AHeczOhoXCGt3TruU3TEXSoDxGXgqV0TF3M7XoQl3okI6uF/JJW4PuKMAld7M4pW67rocLGpfNaUKqb08xDC3Vg6rCAAwN9a3lxSDVx12yEAYbUOiXvYsQyXelwMmYhKzHREiiyq2XnwmZbbM0aNSoignNw4CJperpQW52MnJpMnBUG8/hfGjuVztmacXh7jMyRWPuZTThXwAdA97DQ8DuP9BmWyn3GjBM9zGXWAa7htuoQe534VhCLfK92OFDMrViRqyLeeV6Xvhj3ostGDOroQYOHcsjo1Km++CLN9bMFVUVhKcFs42vQWVrW84R1zFrUzLWrHO7K8AzLXz7rFbIw7xdFBg91BDQHvajo/ggStH8U/wCp/wA0I+b65PCrxSu3j3EpwwNo82UDDFt87qqGULfHPi28NUPXi/CnCN3y3q2yZllFclrfeMzglmhRhSMynK+OvFgUyr58de0ouNrUvfSi/PruTfZhXDpk8+m7kmRul0fSeXTfBvM8ENHt1z5Z3jLuVHVtzmcJjdeRKNhl3i77rgRtjDubT/kYD3mrB8DQ1p/72w0fAtwQj3kCWr33ZooQ1GhhhW3m4TQIamqaABorGBAImrhwlyjlvhgYIMdKwwqNRc6VeHQhGOhMlabwW10bXFjRl316wzvSJLK1M2m5Axl0cEaQrfLq3EyVGH4ZIlR5mgqwV8GMMHcLEX/25BLj77IkPBwkJXeb4cGLL52JgweDqwV76JvGo633EpITex1qBmKx2XklwsCiDWhSjDtOt3tZpUMFbyptsR0qKUbHp9PX5zd1Lyw+Xb9r+HnK41Ad/wDPx+Pw9tt+0dUcm/t23+nXr5Do1G5fmzM9jnUKOJQ7HG/IBhEsdnmkTBg3OYQh+K6sfcGFwfkf9qu+9waWl+9lTOedbSsrKJsauSC0RdjVI3bMh18w02XQIZ4rnvhxW7h31qF73DfeU7uNs3N4m8LbrQ3PFgQriXenpx4nW6RlTz3rB28vl1zN3N4GsdDx7dv37YRqwxfj8NvpKXG+DTe/Lx6fPMWBerPPx266M3HnVRjHU1W24LpTzINpGzvTeyMPxYHeMNCPvP5jGD3uhoRe4l6VCjuqmdZeLR50OEcEvmRwECVvfIvQCjbPXk7MSVdZE5kFudvH2lFabdajeLf2+vjE0PXPGd8fPtPl26el6dozKfL6e1fH26Vuabszc6ZzvfX16cGPPtOPL1ttDZb0urLz16Z2Sqm+l1cbzft62nlHRjKT1ryqb3XJrBgrjjaoasaVJe037mF4G63p7nQr8mOgfycD+J+R+TCxpTvTO5pXu2R33g33rcaTRO587qymk770olOM8GqR23zq80uy8uGNmrd4MEENTW8MrBHWq025Ud1S821eDvzZcSJg5rUrAO1x504FYQ5XoCOo6sROa8iEI83uKjg0Hm4TmH5FeB4Hgf8Am6zfn269PjXfZCcbbDv3OQLyw47Pe7kp36keTvvu3Hatp6b87DJc47SpnPLyYyiZuUcuOxdyytsr5mh8eh501Gg4joT07duEapmee54+VQIMp5b1PT0MXgjzpuMBoC9DbzLXTgXm1mrlRqb1epZ081DSh5V06bQMKDzu+Lho4e533DBh7kKVCPeXUX8RgRhVeBhQX8T/AIv/AATy8uNm/wAM/D9fl59aAe46eXx9szeFvd69v1rrnFQeZ6Tx7Z7B7n6fD9/p57kpI6vx+W/7X2rG9Ezrfbx+n9/PfYtDmQl8MsxdDzfj46KAajR57OC2F6tw6+u0XQdazivGFCt8r13irMprnS4kcI8yGHDhOY4HU7hw4MMObpUX8CNujg7iCMv306GCHemGP8nB/wBGbNfSeXQ72jbrXl7eu9+Fy/H67ft45O7IHp+/z/jtx63zQzt6/HPHbitubdNensZ26LDXr57yuL+ftcZTy43rHp82mAa7z4eefb5OWBL1s6XvF0tOROvbxSoYb5N77P8AuxisNaYvbDLlvJGXWLgtGjdmhi3Fuo3giwiPIGqheGPK7QtMEeZttkI6Phvxw3Zh7yVmGgfhvvczF99DcPeNwj/orCXu9974MZ8vHPNjAw32hyq4pW7Mpq6AvmT2XWjRl8dA9Y6Li8B1zW53MXbHB03cbZ4d3c6+XarqjFfSulXUo32q70a/add6sikHD02+gNXC6vVj1/fbOA0vXbj0qyBq6Hmb9dTDRr06cduMqGDU8zf13810HlfHXgvFPhWc5zblweDd5ly67yGZco/GovvPyf5rgi+4HDizuGMNCPOkhDA73zQwjoW8lNEqXt7VyEliXm/TocqNa69PXt05Z61CNevQ9P8AE676UVKEz8O2/Tr1dfjw0+fG/TrvkutElAdbhZW9a1888XcvBizXPVWxwMvUJUEoMZO4lb7XggcmMHoCQ8KjvW0Y+5He6w+4azBYd6kSMe8hqkfBwf8Ai7lO/wCFK3tmX4GKd8vF+BCuPX26ebyKxfU+P7/7nXmkp9fXtnrM+bpuGnHp5Z6w4NPIZmny/f12qxw9vXFXt4+lIb50z8fLauubyhdct79KMOCJhlbbKsCMcEb3QDU7na8JBjhhM6OFHUXDyHwP5bhHQw81Znk91ZLsDU50KNww95LlN4e91K/J/mQv3IQw2eFgwLrwpEuFztnwIy4b1fNw4rjp7ebeeRhibdf3/wA431CJHz46fP8Aca0aRrfPbznl2TsYd91rjxzxN6Nq1uLHx2Qxxeudxx1QSVWq3XGwYqVfJy7wvC0cmWUwcEIaFQiW6q6lowrVO4Znh0Y9zKam7g9xW9kcPeaVCP4JVjh/9f+mAIUBAAIBAQMFBQoIIBURCQAAALO1AQIDBLIFBgcItgkKCwyxDQ4PEBESaWq3uBMUFhgdr7C5FRcZGhscHh8gISMkJSowMTM0NTc4Oz0+P0BBQkNErboiJicoKSwvMjk6PEZISU1OU1yrrK4rLTZFR0pLTFBSVl1ku7y9vi5RV19hqarAwf+jAAMBzRicRw0LqxEgrqQMh1A1M8GRCHFsBkRByHDoQQYzBcYWGizYaxGE8uMYcsVhmJ5XunfjM5Ud3n/6xPLO4vgMPKf/AD/rH+/d3cjMh9//AO+//n7vL/M2LsJ347/+P+vN/OgyMB38v5/0/wDfl2HNtsu2xyMbhIwZji3NxS2Hciw9o9pyDjtZdVzTRSzwIujm+Io0COjE3sHUozAzSA1smhZCDqNsRp1Vx37TuMGSEY+Xz0pom1sRM2kdmO0LoGTE3tlNx1FHhPtcXNwxGBvMmG5Y9ToHO25ZN3MyO7ERoSOe2DLaY75gtjLY2++HfywWwQhXn/8AvLy+fkXSFJ/Tl/L+j3ea+z3Yt5fM/f5537XO/uZ3n30f08uIZO3KbUk2neWYrh8oxY5JSk2SbZoWMebGyOhWG+OLCFjVoMU9LB3PoP5A6DgZngNHpCmzAczNrFy6UoPM8qSw2LPKORsWcTzkwZ4hRNtjNg4mMMNo3IbHdEhAMuU2YMIF2FdwNM20IhstGTSYgR6B3NhhY4v+jtCOzwQivBLLRzvApzIZEcizqZhqdanpLMOQ3aMExkBmu0C73W7jBjHLHK43J3TyuytxLO3mGMbhO6+DabaMKIsF3YrAWdApY7y2IwPA7l0P2EfcN5oQ8D0kek9AyM2xoxdTJp3u8UwxbsWsbRpjvK2xALsaKdt5CkmxEdxc2Xc3IPMNni9jgviA5m5qtmg9VzbGTotPEMnoCG9skMzaiMVwaJZYRXJFhyxiO2gXe6LyTPaLcZtmwpY06N9uQQo3IIRhvWjgwuc5/sdB7BDoTV1fUdHxOi7yiiOjSLCbRyKJhrEwZkYcqVpzASizoM2LM21bK06liMYbyFCPMU+A6HnP3PUmbqXI2OcjHmaHG4uHfjuzXX7o5EIWYefbFxwlG23Lz4x5i+HZNjuhtidzfzJtOXc7d1m4UzD3QmwZqncUuzGziYRttQtiYyImB4YL40axMLRzbdzZ0GCCdKPEyTgn8XqNTcZHQR6jboYQuRogjmU3SLjLYIJtDUiJYhCxSTG0YRywoR5iNFxz2NzcY6ubQ4IQ0bsOBkc4c5ZTrfrR6CbMeLRRzEYwi5jZjY1cnljuXc0iJgu2BNv6d05dzkUVsuJtgsjl5e5mxoBD7/Pgti+MZJZhdIDthjGDYpZtcjCzTkJZyTbEbqmjS8UKCyaJShzhHI1bHQ2P3vQeqGmHJzCnirjbcZY7oJwwx0buN7GjbCY0WNYhNkGxCM74xDJBrbRKK5GrdttnswyJhhFsabYMnQDa5wEicWmH4T6XM6h9kpOBHqMjV0aDctw0NAIuS3JtTMZkXaztMFymgbuTbaYyHbMmCmFGZbAwuFwI3ad6NiO5peDRDrXqex3eBm8X8R4zqehozaMynMShhFhv2DE2p0LkTnYx5x4NiLc0bkOkp5zsgmMWHM2V3OZ1rq6mI8VY6rZYeRssLnSZowipGnJgRQ3EIwaawZCmFIQ0KYNinQEo4EF6Dr2gtjnbG9obnF8Z77k9LzDc/IfgI5nA1NBjxaSY0Mgjq3duLTZOA6NGhAydxcgm5s3elo4PWXHgf6m3JKd5PLiIG/8A57vu2w2Ne/zTy+fC73l938v592GG7bzfd/PksI0ZY+/+fL+XfyRp0eWPOdxAHPBNuXfjJyFne0owNcbRsuNNq2LrG4tbExcyRILFs+mXKXnfE6m59lpeZufYQ2mMcTHf5nzw3s8337fdiGpthrz4/py2dO/zCfdt3ff3uh3x5ff938vK0bOTMd2OUXBpyx3+bz9/+82p027+7yzHLbIzPL5u/BdNB2cgc2EwUxQLly6LuL4gdRzPSlzVjDQc2B0chYdDDoaYU84Ue+xicwFPN3JTZ1TEelczRiI3dCnGHikXaxuYcsY52OG5qx0NGy8xRDIdz0MHs1WY4lh27nVjEDhiBO7mRA4hDYGxmxZ5vPzbTHe4hZzwPdOVgpy2Q27rsNDAaGpNo9AdL5HUzNTwK6ugHhehoLnQfrYE2Q3GSrqJO6cuW2jimbd23d3cszL/AH2mMZhszbbbunLaFyBCff38tszBA27/AL/NtEMtu/bbz/8AHK43wU8u6MHQuESBcwbY5UxYNxjtm3UrF31nNzKSPEJscVaekOdaWzuIYfA/nAhxYjGGoF14bRYRJjUscdrJty27+UNRw4iBkbYzPOYQywjYwwzEQ8veMIZkwmCNO2XKCOLJNjJrbk2KcyxdU4JczEs3NCOjuYFjnaCHMR4tDCz0nhfhHoYcAIsCOjGiLDMpmGsPB7o0OS0l3TEMRo3qxjdbuCbWYaYilzgZNGbCy73R3u4yDrXqNA1Ot7HxS5zF2I6lxhDgbcqeA0jqmSTGyZFyDjbGNChXDiMckZilYwuEYsWOuCi5uYnUdBmczZg8WixuWPQ5vM3Ot/iUw3pScxuNAaHgsGHThu72hodSnuw3Ny/fq3KJt1Mc0zIeA6TM3sOlu2OZ6DwHZBkdrPORsasQLurMDCzo3U4lGMnTZtg5jkY2LhrhwwhvYYsG5Y5Bowh1Lds5YPCdJA6CGp1nZIPVt1vTtNvAdZTHhh8D1nY3nZpbWOY8JzDGniWegQp3kaedmAOlehfAZHB9I3P/AKeyG2Y8Fp5i7vIaJuRumTYV4Fhcm6QouaMBhYhk0U0mhYjY0GGZoVg532Q6j1Xsih5ik5mOrmGhuLuIw1GxYY7mN3giNKaYIWE0ZtGxHe0cxG7ZHQhmxyV6n8Q08G23Qdb6J0n/AJOYs08Hwj0HM2Dmeoo9lsXcni9jodj+eEp5x6WCu96Roi8Dgb2GTqdRvN77Z2OR0J+I7Kp6WyfpbtjJ940NT+DY+B6S7Z9w9QE+h4ED8p0vE/Ieg7mHxnAh7j+AyLP1EbEPaIeqsLv5XpOZ/GvoFEbFPwDzDkPvpHilET400cyP2lB6z6Jm5GRkR8jY4PO02IeRT2GhaYRH5y7TSe65PMxINmj8ycSEKfzGhdzKMk8Yx8bcu0XbPpDxeh4Oj75d4tNMfRYemaNnIjH8ZYjmeE8LweDoZtjIPSaYeodD6SU0aGr4H12MI5l2xkwuWYaB4hoNB0cyOZzEPANi5vMmJQQ6062xRwMhiQzYRoGmPosIwsaEQEaLNjieMuULBoyKYxTg0XYeJgUU3Lk2wlORo5EF9duZhsAHBhTZTxlF0gXbkY0XOYs+IyaSJvOBT7TGxYYZF3QyDnOtaLKWEyKdUuhuLPgI2bhAuxhxNAo9NzYUU3TxkafVaLBRd8DD2ynR1fCZHhT3W76RZYA2CBkegUe0vB4noPWZroeJ9ppYwA6jM9wpzVsdRzHrn7XI1fVfXClop3PxvS/nKdWxc+N3n0lNmEYkeY4nsDHUoyfoMj6Wwi3f1ORHefmdHJsU3f7SNHwlNiLD1n8LTH9h4j3joffNDmPsNTslnN+Z4P6yx2gLadlcdoHx/wD/owADAfZbH8H6Vutn5TgH6GOZxPof8j3nsbD8JTzn+bwPcfsXyHwnjaf2EX958zkdk0/kfWdD1jwtNP5lsUeAP8mix7h65meueuvyHoHtvsFj8DmHpOhH1TI+sKI7j/B4vA9lu7h/Q9TZ8R/ifMG99R6WPSwyDR/sciOp6ZYrbxLHg2PjLsIwbEIvW+yXYXKbi+i6lPFoyciNBRc6mHpY02slOTAh1rG7xLNwppMinV6xbmStNixRkNhmIu0fWNNrubdgECFmzGFPvFLkkUGK3fQaCjNNcWSOjcusYek9JcBjZHLZRoh5HUvtq0lOTQtjwFFBY6NrlIMcyLshRDqKXiXSmmlpYxsFgseJpuZAU2Fg2I6gXPINmwUUWQaMXVY5vqNEY6uTMaBFWiOp4FusDMskExbaEClpjodRGFDDIpgBkAzaF2ilhkes5MCAXI2KLkbGPUM0hRAWELquCBTkXfI0xchCiBNlQsbZguZ4sRuRYNMaNxHpfQehi3IQoAEh7IsaCxcIFNFwQAKYg3PC6GQ6OiWCjMCHuuZCMablmiPwC03GyaP4242GMLMaYRaWj1mizDVpbNmNEafbcgs2Di3Mj1jrNV0fdM2wb2koN57RzN2FkYanrm46DMo+Euwjo5NHwubT/W9DTzPvm4+cubjIj0PuuR/qZHxP1vjf0rq3PfdTMzO0BXjtA9ZyeyOO0BJntATg7QL1ezRO0Djzedjae4/K/wCB0vtPhRNBu/pTQ+pj87vLH9zQm4h7D0NmIljM9s8IeEflNGxD03qG7RkXQ/E9ZGN3IsnxLcTcx8hzsdSGZSP43VuUQiZD75xaYNkYxWz8DkP6nNjmQ0aLn4xsxHMh8jm3IUC8x7ZqxuFEGw/EcGmHU/lf2GT9iXblmij62n5nqfkf7zR1fqeyKOJHM/xe0Iu36jtAUM+x949Q/qPbPteyaaPxPYyrc+0p+l7KR/W2fTN7Dmd5oWPiek/tfpLO9+0CzH9RoH+DY+Up3nykKOLD5hi3X7CH0OZYo9h3vSsGEacz5GzCOYU+B9citET8Ld6mEVIRh7L6JZyKIwXMh+ZhQN1KaYZnvMLDRGxZLH5CixZRSOT+ljuPdM3I3t387xLG5jco8Zcu6F2JdjqnkcjwLGnRHeR8Z4g53VgeEpjk73M3CHsviLMNxYM30w52NnmdD0T8766WC5mLqe6DR0lwM2yw9gYxjClsm5p94yfAcz6jYoyBW5D3jRjmfQfvKPGe0RuU/wBZ6T+N9oyet3PtGpTzHvGZZojc3PgfQdD/ADbP1vWfCWPtNx9Jkfucj5D+C7j+D8J5HsiX+J2Q72a7+0/i0doLkvaAmp2gxa9oEnnaAuA3PtLEI/tOyJIan1nZHHaAtp2cb2hqG/QfYHB+l/tCA5G8+JclufpLrqfORp+coCxZjZ/UU6lPxGQFin5lopsDSfG2Ybz5TQhZh8S2NHg/CEIaNyPzLCGp8ARuwhxPiIqxs/oLrGORD53M0fic1uQsn6CmLHIPlKaVPoI3XUpPkCy0oQo+FhYp4B+dyW7ofQRsQKbviPGZl2MIUw9R9M3MD8D5G5Clop+ZrFBk+seo2KAhZ/Q6rZf1G5ph9pQeR/qD6i7/ALHvsPSfWd7onoP5mP8Ae/oKKaPqOo/uIH7X9r2SL2gLUf6PaBA72gXq/wATtB6R7Jh+Z/can1FnJ+sou2fsbnZKNn3X2H43Ju/Gf+D/ABfhLtjmMz85uYU734kuZNGT8Lkamp8Bkw4PsPW7w+osR/KeIiU72x/YkbnzmTm/sf1v/d+1/wCz41yIfYWD6ig+B0eC/rOBxPwHSQ+R9N/K2d58rZ0LNHzn7XV/Y+geyavQ9Bd9g0Mj5T9zGn/Yzey9P3naAhR2gowdod2naAl52gL+doDdvaX+/wD/oQ==;637346190;Archivo WSQ_HUELLA Índice derecho;CV1113661649;";
							System.err.println("HiloTransmitirArchivo-->"+strTrmTransmitirArchivo);
							strRespuesta = sendSocketClient("10.18.1.160", "2009", 6000, strTrmTransmitirArchivo);
							System.err.println("HiloTransmitirArchivo<--"+strRespuesta);
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				).start();
		
	}
	
	public String sendSocketClient	(	String ip,
										String puerto,
										int timeOut,
										String trama
									) 
		throws Exception
	{
		Vector<Byte> vecByte;
		byte arrayBytes[];
		Socket socket = null;
		DataOutputStream dataOutputStream;
		DataInputStream dataInputStream;
		Byte b;
		String tramaRecibida;
		boolean fin;

		try {
			
			MessageManager messageManager=new MessageManager(Rescuer.getInstance().loadInfo());
			trama = messageManager.set(trama);
			
			// El socket requiere que la trama finalice con un enter
			trama += "\n";
			timeOut = 0;
			
			socket= new Socket(ip, Integer.parseInt(puerto));
			socket.setSoTimeout(timeOut);
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			
			dataOutputStream.write(trama.getBytes());
			dataInputStream = new DataInputStream(socket.getInputStream());

			fin = false;
			tramaRecibida = null;

			vecByte = new Vector<Byte>();

			while (!fin) {
				byte trama1 = dataInputStream.readByte();
				if (trama1 == 13 || trama1 == 10) {
					fin = true;
				} else {
					vecByte.addElement(trama1);
				}
			}

			arrayBytes = new byte[vecByte.size()];

			for (int i = 0; i < vecByte.size(); i++) {
				b = vecByte.elementAt(i);
				arrayBytes[i] = new Byte(b.toString()).byteValue();
			}

			tramaRecibida = new String(arrayBytes, 0, (arrayBytes.length));
			
			tramaRecibida = messageManager.get(tramaRecibida);

			return tramaRecibida;
		} catch (Exception e) {
			throw e;
		} finally { /** NC 12769 **/
			if(socket != null){
				socket.close();
				socket = null;
			}
			
		}
	}
}
