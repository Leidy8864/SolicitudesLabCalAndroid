package pe.leidy_cs.solicitudeslabcalandroid.services;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.leidy_cs.solicitudeslabcalandroid.activities.ResponseMessage;
import pe.leidy_cs.solicitudeslabcalandroid.models.Solicitud;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "http://leidy8864.pythonanywhere.com/";

    @GET("/rest/solicitudes")
    Call<List<Solicitud>> getSolicitudes();

    @FormUrlEncoded
    @POST("/rest/solicitudes/")
    Call<Solicitud> createSolicitud(@Field("correo") String correo,
                                         @Field("tipo") String tipo,
                                         @Field("motivo") String motivo);
    @Multipart
    @POST("/rest/solicitudes/")
    Call<Solicitud> createSolicitudWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("motivo") RequestBody motivo,
            @Part MultipartBody.Part imagen
    );
}
